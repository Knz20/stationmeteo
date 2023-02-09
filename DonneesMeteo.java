package observateur.stationmeteo;

import java.util.ArrayList;
import java.util.List;

public class DonneesMeteo implements Sujet {
    private List<Observateur> observateurs = new ArrayList();
    private float temperature;
    private float humidite;
    private float pression;


    @Override
    public void enregistrerObservateur(Observateur o) {
        observateurs.add(o);
    }

    @Override
    public void supprimerObservateur(Observateur o) {

        observateurs.remove(o);


    }

    @Override
    public void notiferObservateurs() {
        for ( Observateur obs: observateurs) {
            obs.actualiser(temperature, humidite, pression);
        }

    }



    public void setMesures(float temperature, float humidite, float pression) {
        this.temperature = temperature;
        this.humidite = humidite;
        this.pression = pression;
        notiferObservateurs();
    }

}


