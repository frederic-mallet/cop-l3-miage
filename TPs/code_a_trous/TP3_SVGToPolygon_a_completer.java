package uca.l3.svg;

// Il faudra importer du code du rendu 2 (par exemple classe Polygone et ExtractTriangles...)
// import ...


public class SVGToPolygon {
  
    // On définit le header et footer du svg selon le standard (voir https://developer.mozilla.org/fr/docs/Web/SVG/Tutorial/Getting_Started )
    private static String svgHeader = "<svg width=\"12cm\" height=\"4cm\" viewBox=\"0 0 1200 400\"\n" + 
        "     xmlns=\"http://www.w3.org/2000/svg\" version=\"1.1\">\n" + 
        "  <desc>Mon SVG (COP - Rendu 3)</desc>\n" + 
        "\n" + 
        "  <!-- Show outline of canvas using 'rect' element -->\n" + 
        "  <rect x=\"1\" y=\"1\" width=\"1198\" height=\"398\"\n" + 
        "        fill=\"none\" stroke=\"blue\" stroke-width=\"2\" />\n" + 
        "\n";
	
    private static String svgFooter = "</svg>";
	
    public static int countPolygonTags(String svg) {
        // Compte le nombre de tags de type <polygon ... /> il y a dans le SVG
	}
	
    public static String[] findPolygonTags(String svg) {
        // D'un SVG s, on extrait une liste de strings où chaque string
        // correspond à un tag <polygon ... />
        // NB : utiliser la méthode countPolygonTags peut aider
    }
  
    public static int countPoints(String pointsAttributeString) {
        // D'une chaine de caractère de la forme "points=..." extraite d'un tag <polygon ...>
        // On compte le nombre de points présents
        // Rappel : un point correspond à deux coordonées x et y
        // Example :
        // dans la chaine points="350,75 469,161 423,301 277,301 231,161"
        // 350,75 correspond à un point (x=350, y=75)
    }
	
    public static Polygone tagToPolygon(String polygonTag) {
        // On lit un tag <polygon ...> et on renvoit l'instance de la classe Polygone qui correspond
        // (1) Trouver l'attribut "points=..." dans le tag
        // (2) Trouver les coordonées de chaque vecteur correspondant à un sommet du polygone
        //     NB : utiliser la méthode countPoints peut aider
        // (3) Créer l'instance de Polygone avec ces sommets
    }
	
    public static String polygonToTag(Polygone polygon) {
        // On crée un nouveau tag de type <polygon ... /> en suivant la spécification
        // Voir https://developer.mozilla.org/fr/docs/Web/SVG/Element/polygon
        // Vous pouvez customiser la couleur ou autre
        String tag = "<polygon fill=\"red\" stroke=\"blue\" stroke-width=\"1\" points=\" ";
		
        // Pour chaque point du polygone
        // Compléter le tag avec ses coordonées
        // Au format : x,y (x et y étant des entiers)
        // Attention à ne pas oublier les espaces entre points
		
        // On ferme le tag (toujours selon la spécification SVG)
        tag += "\" />\n";
		
        return tag;
    }
	
    public static void main(String[] args) {
        String svg = "<?xml version=\"1.0\" standalone=\"no\"?>\n"
            + "<!DOCTYPE svg PUBLIC \"-//W3C//DTD SVG 1.1//EN\" \n"
            + "  \"http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd\">\n"
            + "<svg width=\"12cm\" height=\"4cm\" viewBox=\"0 0 1200 400\"\n"
            + "     xmlns=\"http://www.w3.org/2000/svg\" version=\"1.1\">\n"
            + "  <desc>Example polygon01 - pentagon and hexagon</desc>\n"
            + "\n"
            + "  <!-- Show outline of canvas using 'rect' element -->\n"
            + "  <rect x=\"1\" y=\"1\" width=\"1198\" height=\"398\"\n"
            + "        fill=\"none\" stroke=\"blue\" stroke-width=\"2\" />\n"
            + "\n"
            + "  <polygon fill=\"red\" stroke=\"blue\" stroke-width=\"10\" \n"
            + "            points=\"350,75  469,161 \n"
            + "                    423,301 277,301 \n"
            + "                    231,161\" />\n"
            + "  <polygon fill=\"lime\" stroke=\"blue\" stroke-width=\"10\" \n"
            + "            points=\"850,75  958,137.5 958,262.5\n"
            + "                    850,325 742,262.6 742,137.5\" />\n"
            + "</svg>\n";
		
        String finalSVG = SVGToPolygon.svgHeader;
    
        String[] polygonTags = // Extraire la liste des tags <polygon .../> du SVG d'entrée;
		
        // Pour chaque tag <polygon ... />
        for (...) {
            Polygone polygone = // Convertir ce tag en une instance de la classe Polygone;
            Polygone[] triangles = // Extraire les triangles de ce polygone;
			
            // Pour chaque triangle
            for (...) {
                String triangleTag = // Convertir le triangle en son équivalent en tag SVG : <polygon ... />;
                // On complète le SVG final
                finalSVG += triangleTag;
            }
        }
		
        finalSVG += SVGToPolygon.svgFooter;
		
        System.out.println("Mon SVG final (triangulé) = ")
        System.out.println(finalSVG);
        // Pour tester que votre résultat est correct, copier coller le SVG final sur https://www.svgviewer.dev/
        // pour voir les triangles s'afficher
    }
}