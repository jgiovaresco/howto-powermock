package com.github.howto.powermock;

import java.io.File;

public class MaClasse2
{
   public String maMethode(String p_chaine)
   {
      File file = new File(p_chaine);
      return file.getAbsolutePath();
   }
}
