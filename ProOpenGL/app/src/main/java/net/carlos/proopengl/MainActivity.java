package net.carlos.proopengl;

import android.app.Activity;
import android.os.Bundle;
import android.opengl.GLSurfaceView;
import net.carlos.proopengl.game.GameRender;
import android.view.WindowManager;

public class MainActivity extends Activity 
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
	
	getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
	getActionBar().hide();
	
	GLSurfaceView surface = new GLSurfaceView(this);
	surface.setRenderer(new GameRender(true));
	
        setContentView(surface);
    }
}
