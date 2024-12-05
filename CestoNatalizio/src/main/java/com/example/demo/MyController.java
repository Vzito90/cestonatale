package com.example.demo;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {
	
	
ArrayList<Prodotto> listaP = new ArrayList<>();
ArrayList<ProdottoA> listaA = new ArrayList<>();
ArrayList<Cesto> listaC = new ArrayList<>();

int tot=3;
int somma=0;
	
	@GetMapping("/")
	public String getElenco(Model model) {
		listaC.clear();
		listaP.clear();
		//nome, String marca, double prezzo, String luogo, String immagine
		Prodotto p1 = new Prodotto("Tiella di gaeta", "tielleria 3.0", 20, "Formia", "https://blog.giallozafferano.it/cuochinprogress/wp-content/uploads/2016/03/tiella-di-gaeta-e1721055904538-600x800.jpg");
		Prodotto p2 = new Prodotto("Taralli", "Logobass", 5, "Brindisi", "https://www.aziendaagricolapiccolo.it/wp-content/uploads/2021/10/TARALLI-TRADIZIONALI--scaled-600x900.jpg" );
		Prodotto p3 = new Prodotto("Lampascioni conditi", "azienda rocca", 7, "Lecce", "https://www.produzionitipichesalentine.it/wp-content/uploads/la-cupa-prodotti-agricoli-tipici-salentini-lampascioni-conditi-vaso-300-gr.jpg");
		Prodotto p4 = new Prodotto("negramaro", "notte rossa", 12, "lecce", "https://resources.vino.com/data/offertaFileFile/offertaFileFile-321461.jpg");
		
		listaP.add(p1);
		listaP.add(p2);
		listaP.add(p3);
		listaP.add(p4);
		
		model.addAttribute("listaP", listaP);
		
		return "tabella";
	}
	
	@GetMapping("/buy")
	public String recap(@RequestParam("selected") ArrayList<Integer> selected, Model model) {
		
		
		listaA.clear();
		int tot=0;
		   // Verifica se il parametro 'selected' è presente
	    if (selected == null) {
	        // Puoi restituire un messaggio di errore o una pagina che spiega l'errore
	        model.addAttribute("error", "Seleziona almeno un prodotto.");
	        return "errorPage"; // Restituisce una pagina di errore personalizzata
	    }
	    
		for (int i = 0; i < listaP.size(); i++) {
			
			
			
			if (selected.get(i) > 0 ) {
				tot=selected.get(i);
				//nome, String marca, double prezzo, String luogo, String immagine
			somma += selected.get(i) * listaP.get(i).getPrezzo();
			ProdottoA pA1 = new ProdottoA(listaP.get(i).getNome(), listaP.get(i).getMarca(), listaP.get(i).getPrezzo(),
					listaP.get(i).getLuogo(), listaP.get(i).getImmagine(),tot );
			listaA.add(pA1);
			
		}
		}
		
		//System.out.println("La somma totale da pagare è: " + somma + " euro");
		model.addAttribute("listaA", listaA);
		model.addAttribute("somma", somma);
		
		
		Cesto c1 =new Cesto("vimini", 10);
		Cesto c2 =new Cesto("plastica", 12);
		Cesto c3 =new Cesto("carta", 3);
		listaC.add(c1);
		listaC.add(c2);
		listaC.add(c3);
		
		model.addAttribute("listaC", listaC);
		
		
		return "scelta";
	}
	
	

	@GetMapping("/selected")
	public String totale(@RequestParam("group1") double cestoSelezionato, Model model) {
	    // Calcolare il prezzo totale dei prodotti, che è già stato fatto nella funzione recap
	    double prezzoProdotti = somma;  // La variabile somma è già calcolata in recap, quindi la utilizziamo qui
	    System.out.println(somma);
	    // Determinare il prezzo del cesto in base alla selezione
	    double prezzoCesto=0;
	    for (Cesto cesto : listaC) {
	        if (cesto.getPrezzo() == (cestoSelezionato)) {
	            prezzoCesto = cesto.getPrezzo();
	            System.out.println(cesto.getPrezzo());
	            break;
	        }
	    }

	    // Sommare il prezzo dei prodotti e il prezzo del cesto
	    double prezzoTotale = prezzoProdotti+prezzoCesto;

	    // Aggiungere il risultato al modello
	    model.addAttribute("prezzoTotale", prezzoTotale);
	    model.addAttribute("prezzoProdotti", prezzoProdotti);
	    model.addAttribute("prezzoCesto", prezzoCesto);

	    return "totale"; // Restituisce la vista "totale", che può essere una pagina HTML
	}
}