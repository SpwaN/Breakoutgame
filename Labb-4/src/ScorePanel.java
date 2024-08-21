import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.Collator;
import java.util.Arrays;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class ScorePanel extends JFrame implements ActionListener {
	public TopScore tpList;
	private JList tpJList;
	private LatestRuns latestList;
	private JList lateJList;
	private JButton button;
	private String tmp, score;
	public static String[] Highscores;
	private String[] Tmp;
	private Collator collator = Collator.getInstance();
	private int placeHolder = 0, size, highS = 0;

	@SuppressWarnings({ "deprecation", "unchecked", "rawtypes" })
	public ScorePanel() {
		tpList = new TopScore();
		tpJList = new JList(tpList.getList());
		latestList = new LatestRuns();
		lateJList = new JList(latestList.getList());
		button = new JButton("Restart Game!");
		button.addActionListener(this);

		latestList.add("Recent Games");

		for (int i = 0; i < 3; i++) {
			latestList.add(new Integer(placeHolder));
		}

		setLayout(new GridLayout(1, 3));
		add(tpJList);
		add(lateJList);
		add(button);
		Highscores = new String[] { new String("35 cha"), new String("26 kev"), new String("30 esg"),
				new String("48 joe"), new String("20 mak"), new String("74 gab"), new String("28 and"),
				new String("50 per"), new String("23 osk"), new String("32 jam") };
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		InsertName();
	}

	public void HighscoreList() {
		score = Integer.toString(Text.score);
		size = Highscores.length;
		Tmp = new String[size];

		Arrays.sort(Highscores, Collections.reverseOrder());

		for (int k = 0; k <= 9; k++) {
			Tmp[k] = Highscores[k].replaceAll("[^0-9]", "");
		}

		if (collator.compare(score, Tmp[9]) == 1) {
			if (highS == 0) {
				Highscores[9] = score + " " + tmp.substring(0, 3);
			}
			Arrays.sort(Highscores, Collections.reverseOrder());
		}

		tpList.set(0, "Top 10 Highscores");
		for (int i = 0; i < 10; i++) {
			tpList.set(i + 1, Highscores[i]);
		}
	}

	public void InsertName() {
		Arrays.sort(Highscores, Collections.reverseOrder());
		String tal = Highscores[9].replaceAll("[^0-9]", "");
		String score = Integer.toString(Text.score);

		if (collator.compare(score, tal) == 1) {
			highS = 0;
			tmp = JOptionPane.showInputDialog("Ditt namn (Max tre bokstäver): ");
			latestList.set(1, Integer.toString(Text.score));
			latestList.remove(4);
			HighscoreList();
		} else {
			highS = 1;
			HighscoreList();
			latestList.set(1, Integer.toString(Text.score));
			latestList.remove(4);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		RestartGame.restart();
		tpList.top.clear();
	}
}
