package com.stackroute.contoller;

import com.stackroute.exception.TrackAlreadyExistsException;
import com.stackroute.exception.TrackNotFoundExeption;
import com.stackroute.service.TrackService;
import com.stackroute.domain.Track;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("music")
@Api(value = "Musics App", description = "This is a music app implemented in REST")
public class TrackController {

    //Trackservice variable
    TrackService trackService;

    //Set TrackService variable using trackcontroller constructor
    @Autowired
    public TrackController(TrackService trackService){
        this.trackService=trackService;
    }

    //Insert track into the database
    @ApiOperation(value = "Insert a track", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @PostMapping("perform")
    public ResponseEntity<?> insertTrack(@RequestBody Track track) throws TrackAlreadyExistsException {
        ResponseEntity responseEntity;
        trackService.saveTheTrack(track);
        responseEntity=new ResponseEntity<String>("Success-track stored", HttpStatus.CREATED);
        return responseEntity;
        /*try{

        }catch (Exception e){
            responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
            return responseEntity;
        }*/
    }

    //GetAll tracks in the databases
    @ApiOperation(value = "Get All Tracks", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("perform")
    public ResponseEntity<?> getAllTracks() throws TrackAlreadyExistsException {
        ResponseEntity responseEntity;
        responseEntity= new ResponseEntity<List<Track>>(trackService.returnAllTracks(),HttpStatus.ACCEPTED);
        return responseEntity;
/*        try {

        }catch (Exception e){
            responseEntity= new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
            return responseEntity;
        }*/
    }

    //Update the track if already exists
    @ApiOperation(value = "Update the track", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @PutMapping("perform")
    public ResponseEntity<?> updateTracks(@RequestParam("trackid") int trackid,@RequestParam("comments") String comments) throws TrackNotFoundExeption {
        ResponseEntity responseEntity;
        trackService.updateTrack(trackid,comments);
        responseEntity= new ResponseEntity<String>("Succees-track updated",HttpStatus.OK);
        return responseEntity;
       /* try {

        }catch (Exception e){
            responseEntity= new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
            return responseEntity;
        }*/
    }

    //Delete the track
    @ApiOperation(value = "Delete track", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @DeleteMapping("perform")
    public ResponseEntity<?> deleteTrack(@RequestParam int trackid) throws TrackNotFoundExeption {
        trackService.deletTrack(trackid);
        ResponseEntity responseEntity=new ResponseEntity<String>("Success-Track deleted",HttpStatus.ACCEPTED);
        return responseEntity;
       /* try{
            trackService.deletTrack(trackid);
            responseEntity=new ResponseEntity<String>("Success-Track deleted",HttpStatus.CREATED);
            return responseEntity;
        }catch (Exception e){
            responseEntity= new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
            return responseEntity;
        }*/
    }

    //Find the track by trackname
    @ApiOperation(value = "Find the track by name", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("performs")
    public ResponseEntity<?> findTrackByName(@RequestParam String trackname) throws TrackNotFoundExeption {
        ResponseEntity responseEntity;
        responseEntity= new ResponseEntity<List<Track>>(trackService.getByTrackNAme(trackname),HttpStatus.FOUND);
        return responseEntity;
/*        try {

        }catch (Exception e){
            responseEntity=new ResponseEntity<String>(e.getMessage(),HttpStatus.CONFLICT);
            return responseEntity;
        }
    }*/

    }
}
