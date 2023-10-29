package com.example.springjdbctemplate.repository;

import com.example.springjdbctemplate.entity.Sauce;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.List;
import java.util.Optional;

import static com.example.springjdbctemplate.constant.SauceDataSchema.*;

@Repository
public class SauceRepositoryImpl implements SauceRepository {
    private final JdbcTemplate jdbcTemplate;
    public SauceRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public int count() {
        String sqlQuery = "SELECT COUNT(*) FROM sauces";
        return Optional
                .ofNullable(jdbcTemplate.queryForObject(sqlQuery, Integer.class))
                .orElse(0);
    }
    @Override
    public int countBySauceNameSeason(String sauceName, Integer season) {
        String sqlQuery = "SELECT COUNT(*) FROM sauces WHERE sauce_name=? and season=?";
        return Optional
                .ofNullable(jdbcTemplate.queryForObject(sqlQuery, Integer.class, sauceName, season))
                .orElse(0);
    }
    @Override
    public Sauce findById(Long id) {
        String sqlQuery = "SELECT * FROM sauces WHERE id=?";
        return jdbcTemplate.queryForObject(
                sqlQuery,
                new Object[]{id},
                new int[]{Types.INTEGER},
                (rs, idx) -> new Sauce(
                        id,
                        rs.getInt(SEASON),
                        rs.getString(SAUCE_NAME),
                        rs.getLong(SCOVILLE),
                        rs.getInt(SAUCE_NUMBER)
                )
        );
    }
    @Override
    public List<Sauce> findAll() {
        String sqlQuery = "SELECT * FROM sauces";
        return jdbcTemplate.query(
                sqlQuery,
                (rs, idx) -> new Sauce(
                        rs.getLong(ID),
                        rs.getInt(SEASON),
                        rs.getString(SAUCE_NAME),
                        rs.getLong(SCOVILLE),
                        rs.getInt(SAUCE_NUMBER)
                ));
    }
    @Override
    public int insert(Sauce sauce) {
        String sqlQuery = "INSERT INTO sauces (season, sauce_number, sauce_name, scoville) " +
                "VALUES(?, ?, ?, ?)";
        return jdbcTemplate.update(
                sqlQuery,
                sauce.getSeason(),
                sauce.getSauceNumber(),
                sauce.getSauceName(),
                sauce.getScoville()
        );
    }
    @Override
    public int delete(Long id) {
        String sqlQuery = "DELETE FROM sauces WHERE id=?";
        return jdbcTemplate.update(sqlQuery, id);
    }
    @Override
    public int update(Sauce sauce) {
        String sqlQuery = "UPDATE sauces " +
                "set season=?, sauce_number=?, sauce_name=?, scoville=? " +
                "WHERE id=?";
        return jdbcTemplate.update(sqlQuery,
                sauce.getSeason(),
                sauce.getSauceNumber(),
                sauce.getSauceName(),
                sauce.getScoville(),
                sauce.getId());
    }
    // TODO
    @Override
    public int batchInsert(List<Sauce> sauces) {
        return 0;
    }
}
