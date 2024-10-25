
public class TennisGame1 implements TennisGame {

    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == this.player1Name)
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    public String getScore() {
        if (m_score1 == m_score2) {
            return scoreForTied();
        }

        if (m_score1 >= 4 || m_score2 >= 4) {
            return scoreForAdvantageOrWin(m_score1, m_score2);
        }

        return regularScore(m_score1, m_score2);
    }

    private static String regularScore(int m_score1, int m_score2) {
        String score = "";

        score = regularScore(m_score1, score);
        score += "-";
        score = regularScore(m_score2, score);
        return score;
    }

    private static String regularScore(int m_score1, String score) {
        String playerScore = "";
        switch (m_score1) {
            case 0:
                playerScore = "Love";
                break;
            case 1:
                playerScore = "Fifteen";
                break;
            case 2:
                playerScore = "Thirty";
                break;
            case 3:
                playerScore = "Forty";
                break;
        }
        return score + playerScore;
    }

    private static String scoreForAdvantageOrWin(int m_score1, int m_score2) {
        String score;
        int minusResult = m_score1 - m_score2;
        if (minusResult == 1) score = "Advantage player1";
        else if (minusResult == -1) score = "Advantage player2";
        else if (minusResult >= 2) score = "Win for player1";
        else score = "Win for player2";
        return score;
    }

    private String scoreForTied() {
        return switch (m_score1) {
            case 0 -> "Love-All";
            case 1 -> "Fifteen-All";
            case 2 -> "Thirty-All";
            default -> "Deuce";
        };
    }
}
