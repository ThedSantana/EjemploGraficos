package com.apmv1.ejemplograficos;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Beto on 05/06/2015.
 */
public class EjemploView extends View {

    private Drawable miImagen;

    private ShapeDrawable elOvalo;

    public EjemploView (Context context, AttributeSet attrs) {
        super(context);

        Resources res = context.getResources();
        miImagen =  res.getDrawable(R.drawable.logo_upt);
        miImagen.setBounds(30,30,200,200);

        elOvalo = new ShapeDrawable(new OvalShape());
        elOvalo.getPaint().setColor(0xff0000ff);
        elOvalo.setBounds(10,10,310,606);
    }
    @Override protected void onSizeChanged(int ancho, int alto,
                                           int ancho_anterior, int alto_anterior){
        miImagen.setBounds(0, 0, ancho, alto);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //Dibujar
            /*Paint pincel = new Paint();
            pincel.setColor(Color.BLUE);
            pincel.setStrokeWidth(8);
            pincel.setStyle(Paint.Style.STROKE);
            canvas.drawCircle(150, 150, 100, pincel);
            canvas.drawLine(350, 300, 600, 600, pincel);

            pincel.setColor(getResources().getColor(R.color.color_circulo));
            canvas.drawCircle(150, 250, 100, pincel);*/
        //Path trazo = new Path();
        //trazo.addCircle(150, 150, 100, Path.Direction.CCW);

        //trazo.addCircle(150, 150, 100, Path.Direction.CW);
        Path trazo = new Path();
        trazo.moveTo(50, 100);
        trazo.cubicTo(60,70, 150,90, 200,110);
        trazo.lineTo(300,200);
        canvas.drawColor(Color.WHITE);
        Paint pincel = new Paint();
        pincel.setColor(Color.GREEN);
        pincel.setStrokeWidth(8);
        pincel.setStyle(Paint.Style.STROKE);
        canvas.drawPath(trazo, pincel);
        pincel.setStrokeWidth(1);
        pincel.setStyle(Paint.Style.FILL);
        pincel.setTextSize(20);
        pincel.setTypeface(Typeface.SANS_SERIF);
        canvas.drawTextOnPath("APLICACIONES MOVILES I", trazo, 10, 40, pincel);

        //miImagen.draw(canvas);

        //elOvalo.draw(canvas);
    }


}