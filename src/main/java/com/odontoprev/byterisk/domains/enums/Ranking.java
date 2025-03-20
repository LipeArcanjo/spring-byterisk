package com.odontoprev.byterisk.domains.enums;

/**
 * Enumeração que representa os rankings de risco de sinistro de um beneficiário no sistema .
 * <p>
 * O objetivo desta enumeração é classificar os beneficiários de acordo com o nível de risco que representam
 * para o plano odontológico. Essa classificação ajuda no gerenciamento de sinistros e na tomada de decisões
 * preventivas e corretivas.
 * </p>
 * Cada ranking indica o nível de risco, onde:
 * <ul>
 *     <li><b>S</b> - Sem risco.</li>
 *     <li><b>A</b> - Baixo risco.</li>
 *     <li><b>B</b> - Moderado risco.</li>
 *     <li><b>C</b> - Risco considerável.</li>
 *     <li><b>D</b> - Risco elevado.</li>
 *     <li><b>E</b> - Risco muito elevado.</li>
 *     <li><b>F</b> - Máximo risco.</li>
 * </ul>
 */

public enum Ranking {
    S,A,B,C,D,E,F,NA
}
