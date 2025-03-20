package com.odontoprev.byterisk.gateways.controllers.mvc;

import com.odontoprev.byterisk.gateways.responses.PlanoResponse;
import com.odontoprev.byterisk.usecases.interfaces.BeneficiarioService;
import com.odontoprev.byterisk.gateways.requests.BeneficiarioRequest;
import com.odontoprev.byterisk.gateways.responses.BeneficiarioResponse;
import com.odontoprev.byterisk.usecases.interfaces.PlanoService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.UncategorizedSQLException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.NoSuchElementException;

@Controller
@RequestMapping("/view/beneficiarios")
public class BeneficiarioControllerMVC {

    private final BeneficiarioService beneficiarioService;
    private final PlanoService planoService;


    public BeneficiarioControllerMVC(BeneficiarioService beneficiarioService, PlanoService planoService) {
        this.beneficiarioService = beneficiarioService;
        this.planoService = planoService;
    }


    @GetMapping
    public String listarBeneficiarios(Model model) {
        List<BeneficiarioResponse> beneficiarios = beneficiarioService.buscarBeneficiarios();
        model.addAttribute("beneficiarios", beneficiarios);
        return "beneficiario-page";
    }

    @GetMapping("/novo")
    public String novoBeneficiario(Model model) {
        model.addAttribute("beneficiario", new BeneficiarioRequest());
        model.addAttribute("planos", planoService.buscarPlanos());
        return "beneficiario-form";
    }

    @PostMapping("/salvar")
    public String salvarBeneficiario(@ModelAttribute BeneficiarioRequest request, RedirectAttributes attributes) {
        beneficiarioService.criarBeneficiario(request);
        attributes.addFlashAttribute("mensagem", "Beneficiário salvo com sucesso!");
        return "redirect:/view/beneficiarios";
    }

    @GetMapping("/editar/{id}")
    public String editarBeneficiario(@PathVariable Long id, Model model) {
        try {
            BeneficiarioResponse beneficiario = beneficiarioService.buscarBeneficiarioPorId(id);
            model.addAttribute("beneficiario", beneficiario);
            model.addAttribute("planos", planoService.buscarPlanos());
        } catch (NoSuchElementException e) {
            model.addAttribute("erro", "Beneficiário não encontrado com ID: " + id);
            return "redirect:/view/beneficiarios";
        }
        return "beneficiario-form";
    }

    @PostMapping("/atualizar/{id}")
    public String atualizarBeneficiario(@PathVariable Long id, @ModelAttribute BeneficiarioRequest request, RedirectAttributes attributes) {
        beneficiarioService.atualizarBeneficiario(id, request);
        attributes.addFlashAttribute("mensagem", "Beneficiário atualizado com sucesso!");
        return "redirect:/view/beneficiarios";
    }

    @GetMapping("/deletar/{id}")
    public String deletarBeneficiario(@PathVariable Long id, RedirectAttributes attributes) {
        try {
            beneficiarioService.deletarBeneficiario(id);
            attributes.addFlashAttribute("mensagem", "Beneficiário removido com sucesso!");
        } catch (DataIntegrityViolationException e) {
            attributes.addFlashAttribute("erro", "Erro: Beneficiário possui sinistros e não pode ser removido!");
        } catch (UncategorizedSQLException e) {
            attributes.addFlashAttribute("erro", "Erro: Não é possível excluir este beneficiário pois ele possui registros vinculados!");
        } catch (Exception e) {
            attributes.addFlashAttribute("erro", "Erro inesperado ao deletar beneficiário. Contate o suporte.");
        }
        return "redirect:/view/beneficiarios";
    }

    @GetMapping("/{id}")
    public String detalhesBeneficiario(@PathVariable Long id, Model model) {
        BeneficiarioResponse beneficiario = beneficiarioService.buscarBeneficiarioPorId(id);
        model.addAttribute("beneficiario", beneficiario);
        return "beneficiario-detalhes";
    }
}
