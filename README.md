# agh-mwo-enroller-rest

Link do Heroku
https://app-participant2.herokuapp.com/


https://app-participant2.herokuapp.com/meetings	      GET	list of all meetings <br/>
https://app-participant2.herokuapp.com/meetings/{id}	GET	get meeting with given id <br/>
https://app-participant2.herokuapp.com/meetings	      POST	add meeting <br/>
https://app-participant2.herokuapp.com/meetings/{id}	DELETE	delete meeting with given id <br/>
https://app-participant2.herokuapp.com/meetings/{id}	PUT	update meeting with given id <br/>
https://app-participant2.herokuapp.com/meetings/{meetingId}/participants/{participantId}	POST	add participant to a meeting <br/>
https://app-participant2.herokuapp.com/meetings/{meetingId}/participants/{participantId}	DELETE	remove participant from meeting <br/>
https://app-participant2.herokuapp.com/meetings/{id}/participants	GET	return participants for meeting with given id <br/>
https://app-participant2.herokuapp.com/meetings/sortedByTitle GET sorted meetings by title <br/>
https://app-participant2.herokuapp.com/meetings/searchByParticipant?id=user3 GET find meeting by user
