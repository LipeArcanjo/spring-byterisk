package com.odontoprev.byterisk.domains.enums;
/**
 * <p>Enumeração que define os tipos de sinistro odontológico no sistema ByteRisk.</p>
 *
 * <p>O objetivo desta classe é categorizar os sinistros que ocorrem no sistema em dois tipos principais,
 * facilitando a análise e o tratamento adequado dos casos, de acordo com a natureza do sinistro.</p>
 *
 * Os tipos de sinistro são:
 * <ul>
 *     <li><b>Preventivo</b> - Refere-se a procedimentos odontológicos preventivos, como limpezas e check-ups regulares.</li>
 *     <li><b>Corretivo</b> - Refere-se a procedimentos odontológicos que corrigem problemas já existentes, como cáries e extrações.</li>
 * </ul>
 */
public enum TipoSinistro {
    Preventivo,
    Corretivo
}
