package br.com.guilherme.calc.modelo;

@FunctionalInterface
public interface MemoriaObservador {
    
    void valorAlterado(String novoValor);
}
