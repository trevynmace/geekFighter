package player;

public class PlayerControls
{
	private int leftKey;
	private int rightKey;
	private int spaceKey;
	private int punchKey;
	private int kickKey;

	public PlayerControls(int leftKey, int rightKey, int jumpKey, int punchKey, int kickKey)
	{
		this.leftKey = leftKey;
		this.rightKey = rightKey;
		this.spaceKey = jumpKey;
		this.punchKey = punchKey;
		this.kickKey = kickKey;
	}

	int getLeftKey()
	{
		return leftKey;
	}

	int getRightKey()
	{
		return rightKey;
	}

	int getSpaceKey()
	{
		return spaceKey;
	}

	int getPunchKey()
	{
		return punchKey;
	}

	int getKickKey()
	{
		return kickKey;
	}
}