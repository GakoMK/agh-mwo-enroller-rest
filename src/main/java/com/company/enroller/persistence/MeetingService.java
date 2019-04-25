package com.company.enroller.persistence;

import java.util.Collection;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.company.enroller.model.Meeting;
import com.company.enroller.model.Participant;

@Component("meetingService")
public class MeetingService {

	DatabaseConnector connector;

	public MeetingService() {
		connector = DatabaseConnector.getInstance();
	}

	public Collection<Meeting> getAll() {
		String hql = "FROM Meeting";
		Query query = connector.getSession().createQuery(hql);
		return query.list();
	}

	public Meeting findMeeteingById(long id){
		return (Meeting) connector.getSession().get(Meeting.class, id);
	}


	public void add(Meeting meeting){
		Transaction transaction = connector.getSession().beginTransaction();
		connector.getSession().save(meeting);
		transaction.commit();
	}

	public void delete(Meeting meeting) {
		Transaction transaction = connector.getSession().beginTransaction();
		connector.getSession().delete(meeting);
		transaction.commit();
		
	}

	public void update(Meeting meeting) {
		Transaction transaction = connector.getSession().beginTransaction();
		connector.getSession().update(meeting);
		transaction.commit();		
	}

    public void addParticipantToMeeting(long id, Participant participant) {
	    Transaction transaction = connector.getSession().beginTransaction();
	    Meeting meeting = this.findMeeteingById(id);
	    meeting.addParticipant(participant);
	    connector.getSession().save(meeting);
	    connector.getSession().save(participant);
	    transaction.commit();
    }

	public Collection<Participant> getMeetingParticipants(long id) {
	    Meeting meeting = this.findMeeteingById(id);
	    return meeting.getParticipants();
    }

	public void kickParticipantFromMeeting(long id, Participant participant){
		Transaction transaction = connector.getSession().beginTransaction();
	    Meeting meeting = this.findMeeteingById(id);
	    meeting.removeParticipant(participant);
	    connector.getSession().save(meeting);
	    connector.getSession().save(participant);
	    transaction.commit();
	}	
}
