public class team {
    
    private final double team1_strength;
    private final double team2_strength;
    private final double diff;
    private int team1_series;
    private int team2_series;
    double[]team1score = new double[1000];
    double[]team2score = new double[1000];
    private double winnerpct;
    String returner = "";
    
    public team(double a, double b) {
        team1_strength = a;
        team2_strength = b;
        double primary = (a * 1000) - (b * 1000);
        diff = (double) (primary / 1000);
    }
    
    public void series() {
        
        for (int f = 0; f < 1000; f++) {
            int wins1 = 0;
            int wins2 = 0;
            
            for (int i = 0; i < 7; i++) {
                
                int team1wins = 0;
                int team2wins = 0;
                
                // first loop
                for (int k = 0; k < 100; k++) {
                    double winner = Math.random();
                    
                    if (winner <= (.5 + diff)) {
                        team1wins++;
                    } else {
                        team2wins++;
                    }
                }
                
                if (team1wins > team2wins) {
                    wins1++;
                } else {
                    wins2++;
                }
                
                if (wins1 >= 4 || wins2 >= 4) {
                    team1score[f] = wins1;
                    team2score[f] = wins2;
                    break;
                }
            }
        }
    }
    
    public double getDiff() {
        return diff;
    }
    
    public void calc() {
        
        for (int i = 0; i < team1score.length; i++) {
            team1_series += team1score[i];
            team2_series += team2score[i];
        }
        
        team1_series = (int)Math.ceil(team1_series/1000.0);
        team2_series = (int)Math.ceil(team2_series/1000.0);
        
        
    }
    
    public String toString() {
        
        returner += String.format("\nTeam 1 strength: %.3f", team1_strength);
        returner += String.format("\nTeam 2 strength: %.3f", team2_strength);
        
        if (team1_series > team2_series) {
            returner += ("\nOver 100,000 simulations, Team 1 wins the series ");
            returner += (team1_series + " - " + team2_series);
        } else {
            returner += ("\nOver 100,000 simulations, Team 2 wins the series ");
            returner += (team2_series + " - " + team1_series);
        }
        
        return returner;
    }
}