//Title: Myrtle S1 Vs. Elysium S1
//Description:Takes in Vangaurd operator parameters to create datapoints for a graph
//Created: 3/25/2021
//Last Updated: 4/1/2022
//Version: 0.2.0
//Creator: lninga#8229

class MVE{
    public static void main(String[] args){
        //Change values here:

        //Amount of simulated time you want to graph for(in seconds)
        final int simulatedTime = 180;
        //Operator Cost
        final int operatorCst = 0;
        //Stages Starting DP
        final int startingDP = 0;
        //The deployment point(dp) cost of the operator
        final int operatorDPCost = 0;
        //The amount of skill points(sp) an operator starts with on their skill
        final int skillInitialSp = 0;
        //The sp cost of the skill
        final int skillSPCost = 0;
        //The amount of time the skill is activated
        double skillDuration = 0;
        //The total dp generated over the course of the entire skill
        final double skillDPGeneration = 0;


        if(skillDuration <= 0){
            skillDuration = 1;
        }
        createGraphValues(operatorDPCost, simulatedTime, skillDuration, (skillDPGeneration/skillDuration), skillSPCost, skillInitialSp, startingDP);
    }

    public static void createGraphValues(int dPCost, int totalTime, double skillDuration, double dpRate, int skillSPCost, int skillInitialSp, int startingDP, int operatorCst) {
        double dpGainedCount = (0 - operatorCst);
        int currentSP = 0;
        int skillUpTime = 0;
        for(int k = 0; k <= totalTime; k++){
            if((k + startingDP) >= dPCost){
                currentSP++;
                if(currentSP > skillSPCost){
                    dpGainedCount += dpRate;
                    skillUpTime++;
                    if(skillUpTime == skillDuration){
                        currentSP =0;
                        skillUpTime = 0;
                    }
                }
            }
            System.out.format("%.2f" + "\n", dpGainedCount);
        }
   } 
}