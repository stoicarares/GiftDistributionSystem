package writer;

import entertainment.Child;
import writer.ChildrenOutput;

import java.util.ArrayList;
import java.util.List;

public class Writer {
    private List<ChildrenOutput> annualChildren = new ArrayList<>();

    public List<ChildrenOutput> getAnnaulChildren() {
        return annualChildren;
    }

//    @Override
//    public String toString() {
//        StringBuilder stringBuilder =  new StringBuilder();
//        for (List<Child> list : annaulChildren) {
//            stringBuilder.append("children:");
//            stringBuilder.append(list.toString());
//        }
//        return "{" +
//                "annaulChildren=" + stringBuilder +
//                '}';
//    }
}