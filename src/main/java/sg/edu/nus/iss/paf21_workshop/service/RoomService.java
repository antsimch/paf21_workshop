package sg.edu.nus.iss.paf21_workshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import sg.edu.nus.iss.paf21_workshop.model.Room;
import sg.edu.nus.iss.paf21_workshop.repository.RoomRepository;

@Service
public class RoomService {
    
    private RoomRepository roomRepo;

    public RoomService(RoomRepository roomRepo) {
        this.roomRepo = roomRepo;
    }

    public int count() {
        return roomRepo.count();
    }

    public List<Room> getAllRooms() {
        return roomRepo.getAllRooms();
    }

    public Room findRoomById(int roomId) {
        return roomRepo.findRoomById(roomId);
    }

    public boolean saveRoom(Room room) {
        return roomRepo.saveRoom(room);
    }

    public int updateRoom(Room room) {
        return roomRepo.updateRoom(room);
    }

    public int deleteRoom(int roomId) {
        return roomRepo.deleteRoom(roomId);
    }
}
