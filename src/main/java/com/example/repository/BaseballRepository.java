package com.example.repository;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Baseball;

@Repository
public class BaseballRepository {
	@Autowired
	private NamedParameterJdbcTemplate template;
	private static final RowMapper<Baseball> BASEBALL_ROW_MAPPER = (rs, i) -> {
		Baseball baseball = new Baseball();
		baseball.setId(rs.getInt("id"));
		baseball.setLeagueName(rs.getString("league_name"));
		baseball.setTeamName(rs.getString("team_name"));
		baseball.setHeadquarters(rs.getString("headquarters"));
		baseball.setInauguration(rs.getString("inauguration"));
		baseball.setHistory(rs.getString("history"));
		return baseball;
	};
	
	public List<Baseball> findAll(){
		String sql = "SELECT * FROM teams ORDER BY inauguration";
		List<Baseball> baseballList = template.query(sql, BASEBALL_ROW_MAPPER);
		return baseballList;
	}
	
	public Baseball load(Integer id) {
		String sql = "SELECT * FROM teams WHERE id = :id";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		Baseball baseball = template.queryForObject(sql, param, BASEBALL_ROW_MAPPER);
		return baseball;
	}
}
