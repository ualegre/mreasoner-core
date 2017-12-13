package edu.casetools.mreasoner.core.data;

import java.util.Vector;

import edu.casetools.mreasoner.core.data.rules.NextTimeRule;
import edu.casetools.mreasoner.core.data.rules.SameTimeRule;

public class MRules {

	private Vector<SameTimeRule>  sameTimeRules;
	private Vector<NextTimeRule>  nextTimeRules;
	
	public MRules(){
		sameTimeRules     		= new Vector<SameTimeRule>();
	    nextTimeRules           = new Vector<NextTimeRule>();
	}
	
	public Vector<SameTimeRule> getSameTimeRules() {
		return sameTimeRules;
	}

	public void setSameTimeRules(Vector<SameTimeRule> sameTimeRules) {
		this.sameTimeRules = sameTimeRules;
	}

	public Vector<NextTimeRule> getNextTimeRules() {
		return nextTimeRules;
	}

	public void setNextTimeRules(Vector<NextTimeRule> nextTimeRules) {
		this.nextTimeRules = nextTimeRules;
	}

	public void showSystemRules(){
		System.out.println("** SAME TIME RULES:");
		for(int i=0;i<sameTimeRules.size();i++){
			sameTimeRules.get(i).printRule();
		}
		System.out.println("** NEXT TIME RULES:");
		for(int i=0;i<nextTimeRules.size();i++){
			nextTimeRules.get(i).printRule();
		}
		System.out.println();
	
	}	
	

}
