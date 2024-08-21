import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;

@SuppressWarnings("serial")
public class LatestRuns extends AbstractListModel<String> {
	private DefaultListModel latest;

	public LatestRuns() {
		latest = new DefaultListModel();
	}

	public void add(Object Element) {
		latest.addElement(Element);
	}

	public DefaultListModel getList() {
		return latest;
	}

	public void remove(int i) {
		latest.remove(i);
	}

	@Override
	public int getSize() {
		return latest.size();
	}

	@Override
	public String getElementAt(int index) {
		return null;
	}

	public void set(int index, String string) {
		latest.add(index, string);
	}
}
