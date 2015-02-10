package com.lazandrei19.game.util.text;

import com.lazandrei19.game.helper.MouseHelper;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;

import java.awt.*;

public class MenuCenteredText {
    public static UnicodeFont whiteFont = new UnicodeFont(new Font("Times New Roman", Font.PLAIN, 72));
    public static UnicodeFont selectedFont = new UnicodeFont(new Font("Times New Roman", Font.PLAIN, 72));

    public MenuCenteredText() {
        whiteFont.getEffects().add(new ColorEffect(Color.WHITE));
        selectedFont.getEffects().add(new ColorEffect(Color.BLUE));
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        whiteFont.addAsciiGlyphs();
        selectedFont.addAsciiGlyphs();
        try {
            whiteFont.loadGlyphs();
            selectedFont.loadGlyphs();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public UnicodeFont getWhiteFont() {
        return whiteFont;
    }

    public UnicodeFont getSelectedFont() {
        return selectedFont;
    }

    public UnicodeFont getFont(String s, float xt, float yt) {
        int mx = MouseHelper.getX(), my = MouseHelper.getY();

        if (mx > xt && mx < xt + whiteFont.getWidth("Start") && my > yt && my < yt + whiteFont.getHeight("Start"))
            return selectedFont;
        else return whiteFont;
    }
}
