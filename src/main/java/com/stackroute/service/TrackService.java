package com.stackroute.service;

import com.stackroute.exception.TrackAlreadyExistsException;
import com.stackroute.exception.TrackNotFoundExeption;
import com.stackroute.domain.Track;
import java.util.List;

/**This is the service layer where the various methods are
 * mentioned which needs to be overriden in th e implementation
 */

public interface TrackService {

    public void saveTheTrack(Track track) throws TrackAlreadyExistsException;

    public List<Track> returnAllTracks() throws TrackAlreadyExistsException;

    public void updateTrack(int trackId,String comments) throws TrackNotFoundExeption;

    public void deletTrack(int trackid) throws TrackNotFoundExeption;

    public List<Track> getByTrackNAme(String name) throws TrackNotFoundExeption;
}
