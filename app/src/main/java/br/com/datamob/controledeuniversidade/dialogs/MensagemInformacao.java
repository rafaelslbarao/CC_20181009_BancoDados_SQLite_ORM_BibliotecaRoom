package br.com.datamob.controledeuniversidade.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;

import br.com.datamob.controledeuniversidade.R;

public class MensagemInformacao extends DialogFragment
{
    public static final String TITULO = "br.com.datamob.controledeuniversidade.dialogs.mensageminformacao.titulo";
    public static final String MENSAGEM = "br.com.datamob.controledeuniversidade.dialogs.mensageminformacao.mensagem";

    public MensagemInformacao()
    {}

    public static void mostraMensagem(AppCompatActivity activity, String titulo, String mensagem)
    {
        MensagemInformacao mensagemInformacao = new MensagemInformacao();
        Bundle arguments = new Bundle();
        arguments.putString(TITULO, titulo);
        arguments.putString(MENSAGEM, mensagem);
        mensagemInformacao.setArguments(arguments);
        mensagemInformacao.show(activity.getSupportFragmentManager(), MensagemInformacao.class.toString());
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState)
    {
        getArguments().getString(TITULO);
        getArguments().getString(MENSAGEM);
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle(getArguments().getString(TITULO));
        builder.setMessage(getArguments().getString(MENSAGEM));
        builder.setPositiveButton(R.string.OK, null);
        return builder.create();
    }
}
