package br.com.datamob.controledeuniversidade.dialogs;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

public class PopupInformacao
{
    public static void mostraMensagem(final Context context, Handler handler,final String mensagem)
    {
        handler.post(new Runnable()
        {
            @Override
            public void run()
            {
                mostraMensagem(context, mensagem);
            }
        });
    }

    public static void mostraMensagem(Context context, String mensagem)
    {
        Toast.makeText(context, mensagem, Toast.LENGTH_LONG).show();
    }
}
