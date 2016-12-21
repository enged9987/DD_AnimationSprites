package gdx.animationscratch;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class MyGdxGameanimationscratch extends ApplicationAdapter implements InputProcessor{
    SpriteBatch batch;
    Sprite sprVlad;
    Texture txSheet, txTemp, txOne;
    Animation araniVlad[];
    TextureRegion trTemp; // a single temporary texture region
    int fW, fH, fSx, fSy; // height and width of SpriteSheet image - and the starting upper coordinates on the Sprite Sheet
    int nFrame, nPos;

	@Override
    public void create() {
        Gdx.input.setInputProcessor((this));
        nFrame = 0;
        nPos = 0; // the position in the SpriteSheet - 0 to 7
        araniVlad = new Animation[7];
        batch = new SpriteBatch();
        txSheet = new Texture("REALDINO.png.png");
        fW = txSheet.getWidth() / 1;
        fH = txSheet.getHeight() / 7;
        System.out.println(fW + " " + fH);
        for (int i = 0; i < 7; i++) {
            Sprite[] arSprVlad = new Sprite[7];
            //for (int j = 0; j < 8; j++) {
                //fSx = j * fW;
                fSy = i * fH;
                sprVlad = new Sprite(txSheet, fSx, fSy, fW, fH);
                //arSprVlad[j] = new Sprite(sprVlad);
            //}
            araniVlad[i] = new Animation(5.2f, sprVlad);

        }
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        nFrame++;
        if (nFrame > 7) {
            nFrame = 0;
        }
        System.out.println(nPos + " " + nFrame);
        trTemp = araniVlad[nPos].getKeyFrame(nFrame, true);
        batch.begin();
        batch.draw(trTemp, 200, 200);
        batch.end();
    }

    @Override
    public boolean keyDown(int keycode) {
        //Keypad 0-9 is Keycode 96 to 105 in unicode, keycode 0 is 144
        System.out.println("keydown " + keycode);
        if (keycode == Keys.LEFT) {
            nPos = 2;
//            nPos = keycode - 144;
//            System.out.println(nPos);
        }
          if (keycode == Keys.RIGHT) {
            nPos = 3;
//            nPos = keycode - 144;
//            System.out.println(nPos);
        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}

