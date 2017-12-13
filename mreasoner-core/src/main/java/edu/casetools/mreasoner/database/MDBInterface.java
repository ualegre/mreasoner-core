package edu.casetools.mreasoner.database;

import edu.casetools.mreasoner.core.data.MStatus;
import edu.casetools.mreasoner.core.data.states.State;
import edu.casetools.mreasoner.core.data.time.TemporalOperator;
import edu.casetools.mreasoner.core.data.time.Time;

public interface MDBInterface {
	
	public MStatus findLatestEvents(MStatus systemStatus);
	
	public boolean checkTemporalOperator(TemporalOperator TOp,Time time);
	
	public void    insertInernalEvent(State consequence,Time time);
	
	public void    writeLog(MStatus systemStatus);
	
	public void    disconnect();
	
}
