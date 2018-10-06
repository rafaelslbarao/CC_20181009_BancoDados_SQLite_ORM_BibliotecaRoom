package br.com.datamob.controledeuniversidade;

import android.content.Context;
import android.database.sqlite.SQLiteConstraintException;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import br.com.datamob.controledeuniversidade.database_room.DatabaseRoom;
import br.com.datamob.controledeuniversidade.database_room.entity.CidadeEntity;
import br.com.datamob.controledeuniversidade.dialogs.PopupInformacao;

public class CadastroDeCidade extends AppCompatActivity
{
    private Handler handler = new Handler();
    private Context context = CadastroDeCidade.this;
    //
    private TextInputLayout tilNome;
    private TextInputEditText etNome;
    private Spinner spEstado;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_de_cidade);
        ininicializaComponentes();
        carregaEstados();
    }

    private void ininicializaComponentes()
    {
        tilNome = findViewById(R.id.tilNome);
        etNome = findViewById(R.id.etNome);
        spEstado = findViewById(R.id.spEstado);
        FloatingActionButton fabConfirmar = findViewById(R.id.fabConfirmar);
        //
        etNome.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {

            }

            @Override
            public void afterTextChanged(Editable s)
            {
                tilNome.setError(null);
            }
        });
        //
        fabConfirmar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                confirmaTela();
            }
        });
    }

    private void carregaEstados()
    {
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.estados, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spEstado.setAdapter(adapter);
    }

    private void confirmaTela()
    {
        if (!validaTela())
            return;

        salvaRegistroFechaTela();
    }

    private void salvaRegistroFechaTela()
    {
        AsyncTask.execute(new Runnable()
        {
            @Override
            public void run()
            {
                CidadeEntity entity = new CidadeEntity();
                preencheValores(entity);
                try
                {
                    if (DatabaseRoom.getInstance(getApplicationContext()).cidadeDao().insert(entity) != null)
                        fechaTelaSucesso();
                    else
                        PopupInformacao.mostraMensagem(context, handler, "Erro ao inserir");
                }
                catch (SQLiteConstraintException ex)
                {
                    PopupInformacao.mostraMensagem(context, handler, "Código já existe");
                }
            }
        });
    }

    private void preencheValores(CidadeEntity entity)
    {
        entity.setNome(etNome.getText().toString().trim());
        entity.setEstado(spEstado.getSelectedItem().toString());
    }

    private boolean validaTela()
    {
        boolean retorno = true;
        //
        if (etNome.getText().toString().trim().length() == 0)
        {
            tilNome.setError("Informe o nome da cidade");
            retorno = false;
        }
        //
        if (spEstado.getSelectedItemPosition() <= 0)
        {
            PopupInformacao.mostraMensagem(this, "Selecione o estado");
            retorno = false;
        }
        //
        return retorno;
    }

    private void fechaTelaSucesso()
    {
        handler.post(new Runnable()
        {
            @Override
            public void run()
            {
                finish();
            }
        });
    }
}
