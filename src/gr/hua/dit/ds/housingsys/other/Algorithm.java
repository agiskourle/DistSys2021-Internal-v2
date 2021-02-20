package gr.hua.dit.ds.housingsys.other;

public class Algorithm {
	
	private int points = 0;
	
	public int calcPoints(int income, boolean parent_job, int siblings, boolean local, int housing_years, boolean super_senior_status) {
		
		if(income == 0 && parent_job == true) {
			points = 1000;
		} else {
			
			if(income < 10000) {
				points = points + 100;
			}
			
			if(income > 10000 && income < 15000) {
				points = points + 30;
			}
			
			points = points + siblings * 20;
			
			if(local == false) {
				points = points + 50;
			}
			
			points = points - housing_years * 10;
			
		}
		
		if(super_senior_status == true || housing_years >= 4 || local == true) {
			points = 0;
		}
		
		return points;
	}

}
