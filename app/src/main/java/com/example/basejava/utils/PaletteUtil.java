package com.example.basejava.utils;

import android.graphics.Bitmap;
import android.support.v7.graphics.Palette;

import java.util.Arrays;

/**
 * Date:2019/6/5
 * Description:图片主色调获取
 */
public class PaletteUtil {

    private PaletteUtil() {

    }

    /***
     * 获取图片的主色调16进制值
     * @param bitmap
     * @return
     */
    public static int getColorFor16(Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        Palette.Builder pb = new Palette.Builder(bitmap);
        Palette palette = pb.generate();
        Palette.Swatch lightVibrantSwatch = palette.getVibrantSwatch();
        if (lightVibrantSwatch != null) {
            return lightVibrantSwatch.getRgb();
        }
        return 0;
    }

    /***
     * 获取图片的主色调对应的r、g、b值
     * @param bitmap
     * @return [r, g, b]
     */
    public static int[] getRGB(Bitmap bitmap) {
        int color16 = PaletteUtil.getColorFor16(bitmap);
        if (color16 == 0) {
            return new int[]{};
        }
        int r = (color16 & 0xFF0000) >> 16;
        int g = (color16 & 0xFF00) >> 8;
        int b = (color16 & 0xFF);
        return new int[]{r, g, b};
    }

    /***
     * RGB转换HSB
     * @param rgbR
     * @param rgbG
     * @param rgbB
     * @return [H, S, B]
     */
    public static float[] rgb2hsb(int rgbR, int rgbG, int rgbB) {
        assert 0 <= rgbR && rgbR <= 255;
        assert 0 <= rgbG && rgbG <= 255;
        assert 0 <= rgbB && rgbB <= 255;
        int[] rgb = new int[]{rgbR, rgbG, rgbB};
        Arrays.sort(rgb);
        int max = rgb[2];
        int min = rgb[0];

        float hsbB = max / 255.0f;
        float hsbS = (max == 0) ? 0 : ((max - min) / (float) max);

        float hsbH = 0;
        if (max == rgbR && rgbG >= rgbB) {
            hsbH = (rgbG - rgbB) * 60f / (max - min) + 0;
        } else if (max == rgbR && rgbG < rgbB) {
            hsbH = (rgbG - rgbB) * 60f / (max - min) + 360;
        } else if (max == rgbG) {
            hsbH = (rgbB - rgbR) * 60f / (max - min) + 120;
        } else if (max == rgbB) {
            hsbH = (rgbR - rgbG) * 60f / (max - min) + 240;
        } else {
            LogUtil.d("todo");
        }
        return new float[]{hsbH, hsbS, hsbB};
    }

}
