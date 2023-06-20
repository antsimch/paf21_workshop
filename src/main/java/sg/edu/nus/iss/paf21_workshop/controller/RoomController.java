package sg.edu.nus.iss.paf21_workshop.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sg.edu.nus.iss.paf21_workshop.model.Room;
import sg.edu.nus.iss.paf21_workshop.service.RoomService;

@RestController
@RequestMapping(path = "/api/rooms")
public class RoomController {
    
    private RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping(path = "/count")
    public ResponseEntity<Integer> getRoomCount() {
        return new ResponseEntity<Integer>(roomService.count(), HttpStatus.OK);
    }

    @GetMapping(path = "/list")
    public ResponseEntity<List<Room>> getAllRooms() {
        List<Room> rooms = new ArrayList<>();
        rooms = roomService.getAllRooms();

        if (rooms.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(rooms);
        }
    }

    @GetMapping(path = "/{roomId}")
    public ResponseEntity<Room> getRoomById(@PathVariable int roomId) {
        Room room = roomService.findRoomById(roomId);

        if (room == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(room);
        }
    }

    @PostMapping
    public ResponseEntity<Boolean> createRoom(@RequestBody Room room) {
        boolean created = roomService.saveRoom(room);

        if (created) {
            return ResponseEntity.ok().body(created);
        } else {
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping(path = "/{roomId}")
    public ResponseEntity<Integer> deleteRoom(@PathVariable int roomId) {
        int deleted = roomService.deleteRoom(roomId);

        if (deleted == 1) {
            return ResponseEntity.ok().body(deleted);
        } else {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping
    public ResponseEntity<Integer> updateRoom(@RequestBody Room room) {
        int updated = roomService.updateRoom(room);

        if (updated == 1) {
            return ResponseEntity.ok().body(updated);
        } else {
            return ResponseEntity.internalServerError().build();
        }
    }
}
