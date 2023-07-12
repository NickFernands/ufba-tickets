
package com.ufbatickets.project.avaliacoes;

public enum EnumNotas {
    NOTA0(0),
    NOTA1(1),
    NOTA2(2),
    NOTA3(3),
    NOTA4(4),
    NOTA5(5);

    public int valorNota;

    EnumNotas(int valor) {
        valorNota = valor;
    }

    public int getValorNota() {
        return valorNota;
    }
    
}
