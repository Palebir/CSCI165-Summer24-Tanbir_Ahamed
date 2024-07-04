public class Tree {
    private String type; 
    private double moistureLevel; 
    private boolean isDead; // 

    public Tree(String type, double moistureLevel, boolean isDead) {
        this.type = type;
        this.moistureLevel = moistureLevel;
        this.isDead = isDead;
    }

    // calculate the probability of catching fire 
    public double calculateFireRisk(double baseProbCatch) {
        double riskFactor = 1.0;
        if (isDead) {
            riskFactor *= 2; 
        }

        riskFactor *= (1.0 - moistureLevel);
        return baseProbCatch * riskFactor;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getMoistureLevel() {
        return moistureLevel;
    }

    public void setMoistureLevel(double moistureLevel) {
        this.moistureLevel = moistureLevel;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean isDead) {
        this.isDead = isDead;
    }
}