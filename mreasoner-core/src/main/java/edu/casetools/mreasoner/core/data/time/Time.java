package edu.casetools.mreasoner.core.data.time;


import java.util.Calendar;
import java.util.GregorianCalendar;

import edu.casetools.mreasoner.core.configs.TimeConfigs;


public class Time {

	private long 	ITERATION;
	private long 	BASE_TIME_MILLIS;
	private long 	ITERATION_MILLIS;
	private long 	TIME_UNIT_MILLIS;
	private long 	MAX_EXECUTION_TIME;
	private long 	CONFIGS_MAX_EXECUTION_TIME;
	private boolean timeIsGivenInIterations;

	private Calendar c;
	
	public Time( TimeConfigs configs ){
		c = new GregorianCalendar();
		
		this.TIME_UNIT_MILLIS 				= configs.getTimeUnit();
		this.CONFIGS_MAX_EXECUTION_TIME 	= configs.getExecutionTime();	
		timeIsGivenInIterations 			= configs.isSimulation();
		if(configs.isFixedIterationTime())
			System.out.println("USE ITERATION MINIMUM EXECUTION TIME IN MILLIS: "+TIME_UNIT_MILLIS);
		
		ITERATION = 0;
	}
	
	
	public boolean timeIsGivenInIterations() {
		return timeIsGivenInIterations;
	}
	
	public long getTIME_UNIT_MILLIS() {
		return TIME_UNIT_MILLIS;
	}

	public void setTIME_UNIT_MILLIS(long tIME_UNIT_MILLIS) {
		TIME_UNIT_MILLIS = tIME_UNIT_MILLIS;
	}
	public void start(){
		BASE_TIME_MILLIS = System.currentTimeMillis();
		
		if(!timeIsGivenInIterations) 
			MAX_EXECUTION_TIME = CONFIGS_MAX_EXECUTION_TIME + BASE_TIME_MILLIS;
		
	}
	
	public long getBaseTimeMillis(){
		return BASE_TIME_MILLIS;
	}
	
	public long getMaxExecutionTime(){
		return this.MAX_EXECUTION_TIME;
	}
	
	public long getIteration() {	
		return ITERATION;
	}
	
	public long getNextIteration() {	
		return ITERATION+1;
	}
	
	
	public long getCurrentSystemTime() {	
		return System.currentTimeMillis();
	}
	
	public long getSystemRealTimeLastUnit(){
		return ( this.ITERATION_MILLIS - this.TIME_UNIT_MILLIS ); 
	}
	
	public long getSystemRealTime() {
		return ITERATION_MILLIS;
	}

	public void setSystemTime(long systemTime) {
		this.ITERATION = systemTime;
	}

	public void nextTime() {
		ITERATION = ITERATION + 1;
		ITERATION_MILLIS = System.currentTimeMillis();
	}
	
	public long getMillisTimeFromIteration(long iteration){
		long result = (BASE_TIME_MILLIS + (iteration * TIME_UNIT_MILLIS));

		return result;
	}

	public boolean endOfTimeUnit() {
		if(ITERATION_MILLIS > System.currentTimeMillis()) return false;
		else return true;
	}
	
	public long getTimeOfDayInSeconds(){
		int hour,minute;
		c.setTimeInMillis(this.getSystemRealTime());
		
		hour   = c.get(Calendar.HOUR) + (12 * c.get(Calendar.AM_PM));
		minute = c.get(Calendar.MINUTE);

		return ( ( hour*3600) + (minute * 60) + c.get(Calendar.SECOND) );
		
	}
	
	public int getDate(int type){
		c.setTimeInMillis(this.getSystemRealTime());
		return c.get(type);
	}
	
	
	public boolean simulationTime(){
		if( timeIsGivenInIterations )
			return (ITERATION <= CONFIGS_MAX_EXECUTION_TIME);
		else 
			return (ITERATION_MILLIS <= MAX_EXECUTION_TIME) ;
	}


	public String getDateFromRealTimeMillis(){
		String date = "";
		Calendar c = new GregorianCalendar();
		c.setTimeInMillis(this.getSystemRealTime());
		
		date = ""+c.get(Calendar.YEAR)+"-";
		date = date + correctNumber(c.get(Calendar.MONTH)+1) + "-";
		date = date + correctNumber(c.get(Calendar.DAY_OF_MONTH));
		
		return date;
	}
	
	public String getDayTimeFromRealTimeMillis(){
		String date = "";
		Calendar c = new GregorianCalendar();
		c.setTimeInMillis(this.getSystemRealTime());
		
		date = ""+correctNumber(c.get(Calendar.HOUR_OF_DAY))+":";
		date = date + correctNumber(c.get(Calendar.MINUTE)) + ":";
		date = date + correctNumber(c.get(Calendar.SECOND));
		
		return date;
	}
	
	private String correctNumber(int number){
		if(number < 9) return "0"+number;
		else return ""+number;
	}

	
}
