package com.github.howto.powermock;

import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.powermock.api.mockito.PowerMockito.verifyStatic;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.rule.PowerMockRule;

@PrepareForTest({MaClasseStatic.class})
public class MockStatic_RuleTest
{
   @Rule
   public PowerMockRule rule = new PowerMockRule();

   private MaClasse1 m_SUD;

   @Before
   public void setUp()
   {
      m_SUD = new MaClasse1();
   }

   @Test
   public void testMaMethode1_SansMock()
   {
      String resultat = m_SUD.maMethode1("abcd");
      Assert.assertEquals("Ma méthode 1 : -> abcd <-", resultat);
   }

   @Test
   public void testMaMethode1_AvecMock()
   {
      mockStatic(MaClasseStatic.class);
      when(MaClasseStatic.methode1("abcd")).thenReturn("azerty");

      String resultat = m_SUD.maMethode1("abcd");
      Assert.assertEquals("Ma méthode 1 : azerty", resultat);

      verifyStatic();
      MaClasseStatic.methode1("abcd");
   }
}
