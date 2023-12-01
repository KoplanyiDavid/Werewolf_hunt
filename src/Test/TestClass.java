package Test;
import static org.junit.Assert.*;

import Main.GameManager;
import org.junit.*;

public class TestClass {
    private static GameManager gm;

    @BeforeClass
    public static void setUp() {
        gm = new GameManager();
    }

    @Before
    public void setDefaultPlayerStat() {
        gm.player.setPlayerDefaultStatus();
    }

    /** Player class function tests **/
    @Test
    public void testUpdatePlayerStatus() {
        // Test case when playerLife is 3, hasSword is 1, hasShield is 0, and hasLantern is 1
        gm.player.hasSword = 1;
        gm.player.hasShield = 0;
        gm.player.hasLantern = 1;
        gm.player.updatePlayerStatus();

        assertEquals(1, gm.player.hasSword);
        assertEquals(0, gm.player.hasShield);
        assertEquals(1, gm.player.hasLantern);

        // Ensure that the sword, shield, and lantern labels are set to the correct visibility
        assertTrue(gm.ui.swordLabel.isVisible());
        assertFalse(gm.ui.shieldLabel.isVisible());
        assertTrue(gm.ui.lanternLabel.isVisible());
    }

    @Test
    public void testSetPlayerDefaultStatus() {
        gm.player.setPlayerDefaultStatus();
        // Ensure that the correct life icons are visible
        for (int i = 1; i <= 3; i++) {
            assertTrue(gm.ui.lifeLabel[i].isVisible());
        }
        assertEquals(3, gm.player.playerLife);
        assertEquals(5, gm.player.playerMaxLife);
    }
    /** END Player class function tests **/

    /** SceneChanger class function tests **/
    @Test
    public void testShowScene1() {
        gm.sc.showScene1();

        assertTrue(gm.ui.bgPanel[0].isVisible());
        assertFalse(gm.ui.bgPanel[1].isVisible());
        assertFalse(gm.ui.bgPanel[2].isVisible());
    }

    @Test
    public void testShowScene2() {
        gm.sc.showScene2();

        assertFalse(gm.ui.bgPanel[0].isVisible());
        assertTrue(gm.ui.bgPanel[1].isVisible());
        assertFalse(gm.ui.bgPanel[2].isVisible());
    }

    @Test
    public void testShowScene3() {
        gm.sc.showScene3();

        assertFalse(gm.ui.bgPanel[0].isVisible());
        assertFalse(gm.ui.bgPanel[1].isVisible());
        assertTrue(gm.ui.bgPanel[2].isVisible());
    }

    @Test
    public void testShowGameOver() {
        gm.sc.showGameOver(0);

        assertFalse(gm.ui.bgPanel[0].isVisible());
        assertTrue(gm.ui.titleLabel.isVisible());
        assertTrue(gm.ui.restartButton.isVisible());
    }

    @Test
    public void testExitGameOver() {
        gm.sc.exitGameOver();

        assertFalse(gm.ui.titleLabel.isVisible());
        assertFalse(gm.ui.restartButton.isVisible());

        for (int i = 1; i <= 3; i++) {
            assertTrue(gm.ui.lifeLabel[i].isVisible());
        }
        assertEquals(3, gm.player.playerLife);
        assertEquals(5, gm.player.playerMaxLife);
    }
    /** END SceneChanger class function tests **/

    /** Event01 class function tests **/
    @Test
    public void testRestHouse() {
        int life = gm.player.playerLife;
        /* Rest with not full life */
        gm.ev1.restHouse();
        assertEquals(life + 1, gm.player.playerLife);

        gm.player.playerLife = gm.player.playerMaxLife;

        /* Rest with full life */
        assertEquals(gm.player.playerMaxLife, gm.player.playerLife);
    }
    @Test
    public void testAttackKnight() {
        int life = gm.player.playerLife;

        /* Attack without sword */
        gm.player.hasSword = 0;
        gm.ev1.attackKnight();
        assertEquals(life - 1, gm.player.playerLife);

        gm.player.setPlayerDefaultStatus();

        /* Attack with sword */
        gm.player.hasSword = 1;
        gm.ev1.attackKnight();
        assertEquals(life, gm.player.playerLife);
    }

    @Test
    public void testOpenChest() {
        gm.player.hasSword = 0;
        gm.ev1.openChest();
        assertEquals(1, gm.player.hasSword);
    }
    /** END Event01 class function tests **/

    @After
    public void tearDown() {
        gm.stopMusic(gm.currentMusic);
    }

    @AfterClass
    public static void eraseContent() {
        gm = null;
    }
}
