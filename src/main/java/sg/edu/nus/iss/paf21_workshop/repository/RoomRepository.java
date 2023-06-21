package sg.edu.nus.iss.paf21_workshop.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.paf21_workshop.model.Room;

@Repository
public class RoomRepository {
    
    private JdbcTemplate template;

    private final String countSQL = "select count(*) from room";

    private final String findAllSQL = "select * from room";

    private final String findByIdSQL = "select * from room where id = ?";

    private final String deleteSQL = "delete from room where id = ?";

    private final String insertSQL = "insert into room (room_type, price) values (?, ?)";

    private final String updateSQL = "update room set price = ? where id = ?";

    public RoomRepository(JdbcTemplate template) {
        this.template = template;
    }

    public int count() {
        return template.queryForObject(countSQL, Integer.class);
    }

    public List<Room> getAllRooms() {
        return template.query(findAllSQL, BeanPropertyRowMapper.newInstance(Room.class));      
    }

    public Room findRoomById(int roomId) {
        return template.queryForObject(findByIdSQL, BeanPropertyRowMapper.newInstance(Room.class), roomId);
    }

    public Boolean saveRoom(Room room) {

        Boolean saved = template.execute(insertSQL, new PreparedStatementCallback<Boolean>() {

            @Override
            public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                
                ps.setString(1, room.getRoomType());
                ps.setInt(2, room.getPrice());
                return ps.execute();
            }
            
        });

        return saved;
    }

    public int updateRoom(Room room) {
        return template.update(updateSQL, room.getPrice(), room.getId());
    }

    public int deleteRoom(int roomId) {
        return template.update(deleteSQL, roomId);
    }
}
