import java.util.Arrays;
import java.util.Collections;

import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;

public class TopScore extends AbstractListModel<String> {
	public DefaultListModel top;

	public TopScore() {
		top = new DefaultListModel();
	}

	public void add(Object Element) {
		top.addElement(Element);
	}

	public DefaultListModel getList() {
		return top;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return top.size();
	}

	public void ToArraySort() {
		Arrays.sort(top.toArray(), Collections.reverseOrder());
	}

	@Override
	public String getElementAt(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	public void set(int index, String string) {
		top.add(index, string);
	}

}
