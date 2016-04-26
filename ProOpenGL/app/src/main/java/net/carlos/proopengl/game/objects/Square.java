package net.carlos.proopengl.game.objects;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.ByteOrder;
import javax.microedition.khronos.opengles.GL10;
import javax.microedition.khronos.opengles.GL11;

public class Square
{
   private FloatBuffer mFVertexBuffer; 
   private ByteBuffer mColorBuffer; 
   private ByteBuffer mIndexBuffer;

   public Square()
   {
      float[] vertices = 
      {
	 -1.0f, -1.0f,
	 1.0f, -1.0f, 
	 -1.0f, 1.0f,
	 1.0f, 1.0f
      };
      
      float[] my =
      {
	 -2.0f, -2.0f,
	 -2.0f, 2.0f,
	 -1.3f, 1.3f,
	 1.0f, 1.0f
      };
      
      byte maxColor = (byte) 255;

      byte[] colors = 
      {
	 maxColor, 0, maxColor, 0,
	 maxColor, 0, maxColor, 0,
	 maxColor, 0, maxColor, 0,
	 maxColor, 0, maxColor, 0
      };

      byte indices[] =
      {
	 0, 3, 1, 
	 0, 2, 3
      };

      ByteBuffer vbb = ByteBuffer.allocateDirect(my.length * 4);
      vbb.order(ByteOrder.nativeOrder());
      
      mFVertexBuffer = vbb.asFloatBuffer(); 
      mFVertexBuffer.put(my); 
      mFVertexBuffer.position(0);

      mColorBuffer = ByteBuffer.allocateDirect(colors.length);
      mColorBuffer.put(colors); mColorBuffer.position(0);

      mIndexBuffer = ByteBuffer.allocateDirect(indices.length); 
      mIndexBuffer.put(indices); mIndexBuffer.position(0);
   }

   public void draw(GL10 gl)
   { 
      gl.glFrontFace(GL11.GL_CW);
      gl.glVertexPointer(2, GL11.GL_FLOAT, 0, mFVertexBuffer); 
      gl.glColorPointer(4, GL11.GL_UNSIGNED_BYTE, 0, mColorBuffer);
      gl.glDrawElements(GL11.GL_TRIANGLES, 6, GL11.GL_UNSIGNED_BYTE, mIndexBuffer); 
      gl.glFrontFace(GL11.GL_CCW);
   }
}