//package pl.coderslab.expenses.service;
//
//import pl.coderslab.expenses.model.Expense;
//import pl.coderslab.expenses.model.Settlement;
//import pl.coderslab.expenses.model.User;
//
//import java.text.DecimalFormat;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class SettlementServiceImpl implements SettlementService{
//
//    private UserService userService;
//
//    static float minOf2(float x, float y)
//    {
//        return Math.min(x, y);
//    }
//
//    static int getMin(Map<Long,Float> map, List<User> paidFor)
//    {
//        int minInd = 0;
//
//        for (int i = 1; i < paidFor.size(); i++) {
//
//            if (map.get(paidFor.get(i).getId()) < map.get(paidFor.get(minInd).getId())) {
//                minInd = i;
//
//            }
//        }
//        return minInd;
//    }
//
//    static int getMax(Map<Long,Float> map, List<User> paidFor)
//    {
//        int maxInd = 0;
//
//        for (int i = 1; i < paidFor.size(); i++) {
//            if (map.get(paidFor.get(i).getId()) > map.get(paidFor.get(maxInd).getId())) {
//                maxInd = i;
//            }
//        }
//        return maxInd;
//    }
//
//    static List<Settlement> minCashFlowRec(Map<Long,Float> map, List<User> paidFor, List<Settlement> settlements)
//    {
//
//        DecimalFormat f = new DecimalFormat("##.00");
//
//        int mxCredit =  getMax(map, paidFor);
//        int mxDebit =  getMin(map, paidFor);
//
//        float min = Float.parseFloat(f.format(minOf2(-map.get(paidFor.get(mxDebit).getId()), map.get(paidFor.get(mxCredit).getId()))));
//
//        if (map.get(paidFor.get(mxCredit).getId()) == 0 && map.get(paidFor.get(mxDebit).getId()) == 0 || min<=0)
//            return settlements;
//
//        map.put(paidFor.get(mxCredit).getId(),map.get(paidFor.get(mxCredit).getId()) - min);
//        map.put(paidFor.get(mxDebit).getId(),map.get(paidFor.get(mxDebit).getId()) + min);
//
//        Float finalAmt = min;
//        Long finalPayBy = paidFor.get(mxDebit).getId();
//        Long finalPayTo = paidFor.get(mxCredit).getId();
//
//
//        Settlement obj = new Settlement (finalPayTo,finalPayBy,finalAmt);
//        settlements.add(obj);
//
//        minCashFlowRec(map, paidFor, settlements);
//        return settlements;
//    }
//    @Override
//    public List<Settlement> getSettlement(Long id) {
//
//        List<Expense> exp = userService.getExpenses(id);
//        List<User> paidFor = userService.getUsers(id);
//
//        DecimalFormat f = new DecimalFormat("##.00");
//
//        Map<Long,Float> map = new HashMap<>();
//
//        for (Expense expense : exp) {
//            Double expAmt = expense.getAmount();
//            int totalUser = expense.getPaidFor().size();
//            long totalUsr = totalUser;
//
//            map.putIfAbsent(user.getAmountPaid(), 0F);
//
//            double val = map.get(user.getAmountPaid()) + (expense.getAmount()) -  (expense.getAmount() / (float) totalUsr));
//            map.put(expense.getExpPaidBy(), Float.valueOf(f.format(val)));
//
//            for (int j = 0; j < totalUser - 1; j++) {
//                map.putIfAbsent(expense.getUsrSplitBtw().get(j).getId(), 0F);
//                map.put(expense.getUsrSplitBtw().get(j).getId(), Float.valueOf(f.format(map.get(expense.getUsrSplitBtw().get(j).getId()) - ((float) expAmt / (float) totalUsr))));
//            }
//        }
//
//        List<Settlement> settlements = new ArrayList<>();;
//
//
//        return minCashFlowRec(map, paidFor,settlements,exp.get());
//
//
//    }
//
//
//}
