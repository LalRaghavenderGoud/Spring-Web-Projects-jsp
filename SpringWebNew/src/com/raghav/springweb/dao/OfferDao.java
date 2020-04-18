package com.raghav.springweb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("offerDao")
public class OfferDao {

	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	public List<Offers> getOffers() {

		return jdbc.query("select * from offers", new RowMapper<Offers>() {

			@Override
			public Offers mapRow(ResultSet rs, int rowNum) throws SQLException {

				Offers offer = new Offers();

				offer.setId(rs.getInt("id"));
				offer.setName(rs.getString("name"));
				offer.setEmail(rs.getString("email"));
				offer.setText(rs.getString("text"));

				return offer;
			}

		});

		/*
		 * return jdbc.query("select * from offers", new RowMapper<Offers>() {
		 * 
		 * public Offers mapRow(ResultSet rs, int rowNum) throws SQLException { Offers
		 * offer = new Offers(); offer.setId(rs.getInt("id"));
		 * offer.setName(rs.getString("name")); offer.setEmail(rs.getString("email"));
		 * offer.setText(rs.getString("text"));
		 * 
		 * return offer; }
		 * 
		 * });
		 */

	}

	public Offers getOffers(int id) {

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);

		return jdbc.queryForObject("select * from offers where id = :id", params, new RowMapper<Offers>() {

			public Offers mapRow(ResultSet rs, int rowNum) throws SQLException {
				Offers offer = new Offers();
				offer.setId(rs.getInt("id"));
				offer.setName(rs.getString("name"));
				offer.setEmail(rs.getString("email"));
				offer.setText(rs.getString("text"));

				return offer; 
			}

		});

	}

	public boolean deleteOffer(int id) {
		MapSqlParameterSource param = new MapSqlParameterSource("id", id);
		return jdbc.update("delete from offers where id = :id", param) == 1;
	}

	@Transactional
	public boolean createOffer(Offers offer) {

		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(offer);
		return jdbc.update("insert into offers(name,email,text) values(:name,:email,:text)", param) == 1;
	}

	public int[] createOffer(List<Offers> offer) {
		SqlParameterSource[] param = SqlParameterSourceUtils.createBatch(offer);

		return jdbc.batchUpdate("insert into offers(id,name,email,text) values(:id,:name,:email,:text)", param);
	}

	public boolean updateOffer(Offers offer) {

		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(offer);
		return jdbc.update("update offers set name=:name,email=:email,text=:text where id=:id", param) == 1;
	}
}
