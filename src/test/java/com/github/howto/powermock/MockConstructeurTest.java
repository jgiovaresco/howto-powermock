package com.github.howto.powermock;

import  static org.mockito.Mockito.mock;
import  static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.whenNew;
import static org.powermock.api.mockito.PowerMockito.verifyNew;
import junit.framework.Assert;

import java.io.File;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(MaClasse2.class)
public class MockConstructeurTest
{
   private MaClasse2 m_SUD;

   @Before
   public void setUp()
   {
      m_SUD = new MaClasse2();
   }

   @Test
   public void testMaMethode1_AvecMock() throws Exception
   {
      File mockFile = mock(File.class);
      when(mockFile.getAbsolutePath()).thenReturn("monChemin");

      whenNew(File.class).withArguments("monFichier").thenReturn(mockFile);

      String resultat = m_SUD.maMethode("monFichier");
      Assert.assertEquals("monChemin", resultat);

      verifyNew(File.class).withArguments("monFichier");
   }

}
