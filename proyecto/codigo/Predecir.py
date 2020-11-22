def predecir(dataset): 
   if(list(dataset["punt_ingles"])[0]>=51.0):
      if(list(dataset["punt_ciencias_sociales"])[0]>=50.0):
         if(list(dataset["punt_quimica"])[0]>=50.0):
            if(list(dataset["punt_biologia"])[0]>=51.0):
               if(list(dataset["punt_lenguaje"])[0]>=56.0):
                  if(list(dataset["punt_filosofia"])[0]>=51.0):
                     return True
                  else: 
                     return False
               else: 
                  if(list(dataset["punt_matematicas"])[0]>=60.0):
                     return True
                  else: 
                     if(list(dataset["punt_filosofia"])[0]>=47.0):
                        if(list(dataset["punt_fisica"])[0]>=57.0):
                           return True
                        else: 
                           return False
                     else: 
                        if(list(dataset["punt_fisica"])[0]>=45.0):
                           return True
                        else: 
                           return False
            else: 
               if(list(dataset["punt_lenguaje"])[0]>=55.0):
                  if(list(dataset["punt_matematicas"])[0]>=57.0):
                     return True
                  else: 
                     if(list(dataset["punt_fisica"])[0]>=57.0):
                        return False
                     else: 
                        if(list(dataset["punt_filosofia"])[0]>=51.0):
                           return False
                        else: 
                           return False
               else: 
                  if(list(dataset["punt_matematicas"])[0]>=50.0):
                     if(list(dataset["punt_fisica"])[0]>=54.0):
                        return True
                     else: 
                        if(list(dataset["punt_filosofia"])[0]>=44.0):
                           return False
                        else: 
                           return False
                  else: 
                     if(list(dataset["punt_filosofia"])[0]>=41.0):
                        if(list(dataset["punt_fisica"])[0]>=48.0):
                           return False
                        else: 
                           return True
                     else: 
                        return False
         else: 
            if(list(dataset["punt_lenguaje"])[0]>=51.0):
               if(list(dataset["punt_biologia"])[0]>=50.0):
                  if(list(dataset["punt_matematicas"])[0]>=52.0):
                     if(list(dataset["punt_fisica"])[0]>=52.0):
                        return True
                     else: 
                        return False
                  else: 
                     if(list(dataset["punt_filosofia"])[0]>=47.0):
                        return False
                     else: 
                        return False
               else: 
                  if(list(dataset["punt_matematicas"])[0]>=54.0):
                     if(list(dataset["punt_filosofia"])[0]>=43.0):
                        return False
                     else: 
                        return True
                  else: 
                     if(list(dataset["punt_filosofia"])[0]>=41.0):
                        if(list(dataset["punt_fisica"])[0]>=60.0):
                           return True
                        else: 
                           return False
                     else: 
                        return False
            else: 
               if(list(dataset["punt_biologia"])[0]>=50.0):
                  if(list(dataset["punt_matematicas"])[0]>=51.0):
                     if(list(dataset["punt_fisica"])[0]>=57.0):
                        return True
                     else: 
                        if(list(dataset["punt_filosofia"])[0]>=52.0):
                           return False
                        else: 
                           return False
                  else: 
                     if(list(dataset["punt_filosofia"])[0]>=51.0):
                        return False
                     else: 
                        return False
               else: 
                  if(list(dataset["punt_matematicas"])[0]>=54.0):
                     return True
                  else: 
                     if(list(dataset["punt_filosofia"])[0]>=47.0):
                        return False
                     else: 
                        return False
      else: 
         if(list(dataset["punt_lenguaje"])[0]>=53.0):
            if(list(dataset["punt_biologia"])[0]>=51.0):
               if(list(dataset["punt_quimica"])[0]>=52.0):
                  if(list(dataset["punt_matematicas"])[0]>=53.0):
                     return True
                  else: 
                     return False
               else: 
                  if(list(dataset["punt_matematicas"])[0]>=53.0):
                     if(list(dataset["punt_fisica"])[0]>=54.0):
                        return True
                     else: 
                        return False
                  else: 
                     if(list(dataset["punt_fisica"])[0]>=56.0):
                        return False
                     else: 
                        if(list(dataset["punt_filosofia"])[0]>=55.0):
                           return False
                        else: 
                           return False
            else: 
               if(list(dataset["punt_quimica"])[0]>=49.0):
                  if(list(dataset["punt_fisica"])[0]>=51.0):
                     if(list(dataset["punt_filosofia"])[0]>=44.0):
                        return True
                     else: 
                        return True
                  else: 
                     if(list(dataset["punt_matematicas"])[0]>=59.0):
                        return False
                     else: 
                        if(list(dataset["punt_filosofia"])[0]>=46.0):
                           return False
                        else: 
                           return False
               else: 
                  if(list(dataset["punt_filosofia"])[0]>=41.0):
                     if(list(dataset["punt_matematicas"])[0]>=50.0):
                        return True
                     else: 
                        return False
                  else: 
                     return False
         else: 
            if(list(dataset["punt_biologia"])[0]>=50.0):
               if(list(dataset["punt_matematicas"])[0]>=53.0):
                  if(list(dataset["punt_fisica"])[0]>=50.0):
                     if(list(dataset["punt_filosofia"])[0]>=55.0):
                        return False
                     else: 
                        if(list(dataset["punt_quimica"])[0]>=47.0):
                           return True
                        else: 
                           return False
                  else: 
                     if(list(dataset["punt_quimica"])[0]>=55.0):
                        return False
                     else: 
                        return False
               else: 
                  if(list(dataset["punt_quimica"])[0]>=53.0):
                     return True
                  else: 
                     if(list(dataset["punt_filosofia"])[0]>=44.0):
                        return True
                     else: 
                        return False
            else: 
               if(list(dataset["punt_matematicas"])[0]>=53.0):
                  if(list(dataset["punt_quimica"])[0]>=49.0):
                     if(list(dataset["punt_fisica"])[0]>=52.0):
                        return True
                     else: 
                        return False
                  else: 
                     if(list(dataset["punt_fisica"])[0]>=46.0):
                        return True
                     else: 
                        return False
               else: 
                  if(list(dataset["punt_quimica"])[0]>=54.0):
                     return True
                  else: 
                     if(list(dataset["punt_filosofia"])[0]>=45.0):
                        if(list(dataset["punt_fisica"])[0]>=65.0):
                           return False
                        else: 
                           return False
                     else: 
                        if(list(dataset["punt_fisica"])[0]>=53.0):
                           return False
                        else: 
                           return False
   else: 
      if(list(dataset["punt_quimica"])[0]>=52.0):
         if(list(dataset["punt_ciencias_sociales"])[0]>=51.0):
            if(list(dataset["punt_lenguaje"])[0]>=55.0):
               if(list(dataset["punt_filosofia"])[0]>=44.0):
                  if(list(dataset["punt_matematicas"])[0]>=59.0):
                     return True
                  else: 
                     if(list(dataset["punt_biologia"])[0]>=54.0):
                        return False
                     else: 
                        if(list(dataset["punt_fisica"])[0]>=57.0):
                           return False
                        else: 
                           return False
               else: 
                  if(list(dataset["punt_biologia"])[0]>=51.0):
                     return False
                  else: 
                     return False
            else: 
               if(list(dataset["punt_biologia"])[0]>=49.0):
                  if(list(dataset["punt_matematicas"])[0]>=50.0):
                     if(list(dataset["punt_fisica"])[0]>=54.0):
                        return True
                     else: 
                        if(list(dataset["punt_filosofia"])[0]>=53.0):
                           return False
                        else: 
                           return False
                  else: 
                     if(list(dataset["punt_fisica"])[0]>=48.0):
                        return True
                     else: 
                        return False
               else: 
                  if(list(dataset["punt_filosofia"])[0]>=45.0):
                     if(list(dataset["punt_matematicas"])[0]>=59.0):
                        return True
                     else: 
                        if(list(dataset["punt_fisica"])[0]>=56.0):
                           return False
                        else: 
                           return False
                  else: 
                     if(list(dataset["punt_matematicas"])[0]>=50.0):
                        return True
                     else: 
                        return False
         else: 
            if(list(dataset["punt_biologia"])[0]>=51.0):
               if(list(dataset["punt_matematicas"])[0]>=54.0):
                  if(list(dataset["punt_lenguaje"])[0]>=49.0):
                     if(list(dataset["punt_fisica"])[0]>=51.0):
                        return True
                     else: 
                        return False
                  else: 
                     return False
               else: 
                  if(list(dataset["punt_lenguaje"])[0]>=54.0):
                     if(list(dataset["punt_filosofia"])[0]>=46.0):
                        return True
                     else: 
                        return False
                  else: 
                     if(list(dataset["punt_fisica"])[0]>=54.0):
                        return False
                     else: 
                        if(list(dataset["punt_filosofia"])[0]>=47.0):
                           return False
                        else: 
                           return False
            else: 
               if(list(dataset["punt_lenguaje"])[0]>=51.0):
                  if(list(dataset["punt_matematicas"])[0]>=55.0):
                     if(list(dataset["punt_filosofia"])[0]>=50.0):
                        return False
                     else: 
                        if(list(dataset["punt_fisica"])[0]>=65.0):
                           return False
                        else: 
                           return False
                  else: 
                     if(list(dataset["punt_fisica"])[0]>=56.0):
                        return False
                     else: 
                        if(list(dataset["punt_filosofia"])[0]>=49.0):
                           return False
                        else: 
                           return False
               else: 
                  if(list(dataset["punt_filosofia"])[0]>=44.0):
                     if(list(dataset["punt_matematicas"])[0]>=61.0):
                        return False
                     else: 
                        if(list(dataset["punt_fisica"])[0]>=52.0):
                           return False
                        else: 
                           return False
                  else: 
                     if(list(dataset["punt_matematicas"])[0]>=63.0):
                        return False
                     else: 
                        if(list(dataset["punt_fisica"])[0]>=52.0):
                           return False
                        else: 
                           return False
      else: 
         if(list(dataset["punt_ciencias_sociales"])[0]>=51.0):
            if(list(dataset["punt_lenguaje"])[0]>=54.0):
               if(list(dataset["punt_filosofia"])[0]>=47.0):
                  if(list(dataset["punt_matematicas"])[0]>=59.0):
                     return True
                  else: 
                     if(list(dataset["punt_biologia"])[0]>=53.0):
                        return False
                     else: 
                        if(list(dataset["punt_fisica"])[0]>=48.0):
                           return True
                        else: 
                           return False
               else: 
                  if(list(dataset["punt_matematicas"])[0]>=58.0):
                     if(list(dataset["punt_biologia"])[0]>=58.0):
                        return True
                     else: 
                        return False
                  else: 
                     if(list(dataset["punt_biologia"])[0]>=53.0):
                        return False
                     else: 
                        if(list(dataset["punt_fisica"])[0]>=59.0):
                           return False
                        else: 
                           return False
            else: 
               if(list(dataset["punt_biologia"])[0]>=52.0):
                  if(list(dataset["punt_matematicas"])[0]>=53.0):
                     if(list(dataset["punt_filosofia"])[0]>=50.0):
                        return True
                     else: 
                        return False
                  else: 
                     if(list(dataset["punt_fisica"])[0]>=53.0):
                        return True
                     else: 
                        if(list(dataset["punt_filosofia"])[0]>=39.0):
                           return True
                        else: 
                           return False
               else: 
                  if(list(dataset["punt_matematicas"])[0]>=59.0):
                     if(list(dataset["punt_filosofia"])[0]>=49.0):
                        return False
                     else: 
                        if(list(dataset["punt_fisica"])[0]>=56.0):
                           return False
                        else: 
                           return False
                  else: 
                     if(list(dataset["punt_filosofia"])[0]>=48.0):
                        if(list(dataset["punt_fisica"])[0]>=52.0):
                           return False
                        else: 
                           return False
                     else: 
                        if(list(dataset["punt_fisica"])[0]>=54.0):
                           return True
                        else: 
                           return False
         else: 
            if(list(dataset["punt_lenguaje"])[0]>=52.0):
               if(list(dataset["punt_biologia"])[0]>=50.0):
                  if(list(dataset["punt_matematicas"])[0]>=53.0):
                     if(list(dataset["punt_fisica"])[0]>=48.0):
                        if(list(dataset["punt_filosofia"])[0]>=49.0):
                           return True
                        else: 
                           return False
                     else: 
                        return False
                  else: 
                     if(list(dataset["punt_fisica"])[0]>=51.0):
                        return True
                     else: 
                        if(list(dataset["punt_filosofia"])[0]>=44.0):
                           return False
                        else: 
                           return False
               else: 
                  if(list(dataset["punt_matematicas"])[0]>=57.0):
                     if(list(dataset["punt_filosofia"])[0]>=47.0):
                        return True
                     else: 
                        if(list(dataset["punt_fisica"])[0]>=57.0):
                           return False
                        else: 
                           return False
                  else: 
                     if(list(dataset["punt_filosofia"])[0]>=42.0):
                        if(list(dataset["punt_fisica"])[0]>=54.0):
                           return False
                        else: 
                           return False
                     else: 
                        if(list(dataset["punt_fisica"])[0]>=43.0):
                           return False
                        else: 
                           return False
            else: 
               if(list(dataset["punt_matematicas"])[0]>=54.0):
                  if(list(dataset["punt_biologia"])[0]>=51.0):
                     if(list(dataset["punt_fisica"])[0]>=59.0):
                        return True
                     else: 
                        if(list(dataset["punt_filosofia"])[0]>=51.0):
                           return False
                        else: 
                           return False
                  else: 
                     if(list(dataset["punt_fisica"])[0]>=50.0):
                        return True
                     else: 
                        return False
               else: 
                  if(list(dataset["punt_biologia"])[0]>=51.0):
                     if(list(dataset["punt_filosofia"])[0]>=41.0):
                        if(list(dataset["punt_fisica"])[0]>=54.0):
                           return True
                        else: 
                           return False
                     else: 
                        return False
                  else: 
                     if(list(dataset["punt_filosofia"])[0]>=51.0):
                        return False
                     else: 
                        if(list(dataset["punt_fisica"])[0]>=49.0):
                           return False
                        else: 
                           return False
