//package pl.coderslab.expenses.model;
//
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//
//public class EvenDistribution {
//
//
//        private ConcurrentHashMap<User,Double> initialPayment = new ConcurrentHashMap<>();
//
//        private ConcurrentHashMap<User,Double> computations;
//
//        public EvenDistribution(Map<User,Double> initialPayment){
//            this.initialPayment.putAll(initialPayment);
//            computations = new ConcurrentHashMap<>();
//            subtract();
//        }
//
//        private double getAmountToDistribute(){
//
//            double totalAmount = 0;
//
//            for(double amount: initialPayment.values()){
//                totalAmount = totalAmount + amount;
//            }
//
//            double amountToDistribute = (totalAmount/initialPayment.size());
//
//            return amountToDistribute;
//        }
//
//        public void subtract(){
//
//            double amountToDistribute = getAmountToDistribute();
//
//            for(User user: initialPayment.keySet()){
//                double remainingAmount =  initialPayment.get(user) - amountToDistribute ;
//                computations.put(user, remainingAmount);
//            }
//        }
//
//        public void calculate(){
//
//            for(User paidTo: computations.keySet()){
//                Double p1amount = computations.get(paidTo);
//
//                if(p1amount>0){
//                    for(User paidBy: computations.keySet()){
//                        double p2amount = computations.get(paidBy);
//
//                        if(!paidBy.getName().equals(paidTo.getName()) && p2amount<0){
//                            double result = p1amount + p2amount;
//                            computations.put(paidTo, 0D);
//                            computations.put(paidBy, result);
//
//                            System.out.println(paidTo.getName() + "=>" + p1amount + "=>" + paidBy.getName());
//
//                            break;
//                        }
//                    }
//                }
//
//            }
//
//
//            for(User paidTo: computations.keySet()){
//                if(computations.get(paidTo.getName())!=0){
//                    calculate();
//                }
//            }
//
//        }
//
//    }

