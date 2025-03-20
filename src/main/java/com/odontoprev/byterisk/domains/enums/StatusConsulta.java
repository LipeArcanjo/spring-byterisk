package com.odontoprev.byterisk.domains.enums;

/**
 * <p>Enumeração que define os possíveis status de uma consulta odontológica no sistema ByteRisk.</p>
 *
 * <p>O propósito desta enumeração é acompanhar o estado das consultas realizadas pelos beneficiários,
 * permitindo um controle mais eficaz de agendamentos, históricos de atendimento e cancelamentos.</p>
 *
 * Os possíveis status são:
 * <ul>
 *     <li><b>Pendente</b> - A consulta foi agendada, mas ainda não foi realizada.</li>
 *     <li><b>Realizada</b> - A consulta foi concluída com sucesso.</li>
 *     <li><b>Cancelada</b> - A consulta foi cancelada e não será realizada.</li>
 * </ul>
 */

public enum StatusConsulta {
    Pendente,
    Realizada,
    Cancelada
}
