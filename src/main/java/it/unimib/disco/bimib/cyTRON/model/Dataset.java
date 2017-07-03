package it.unimib.disco.bimib.cyTRON.model;

import org.rosuda.JRI.REXP;

import it.unimib.disco.bimib.cyTRON.controller.DatasetController;
import it.unimib.disco.bimib.cyTRON.model.R.RConnectionManager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Dataset {
    
    private String name;

	private Map<String, Gene> genes;
    private Map<String, Type> types;
    private Map<String, Sample> samples;
    private Set<Event> events;
    
    public Dataset(String name, String path, String type) {
        this.name = name;
    	
    	switch (type) {
            case DatasetController.GENOTYPES:
                importGenotypes(name, path);
                break;
            case DatasetController.GISTIC:
                importGistic(name, path);
                break;
            case DatasetController.MAF:
                importMaf(name, path);
                break;
            default:
                break;
        }
    	
    	retrieveSamples();
    	retrieveEvents();
    }
    
    public void deleteDataset() {
        // create and execute the command
        String command = "rm(" + name + ")";
        RConnectionManager.eval(command);
    }
    
    private void importGenotypes(String name, String path) {
        // create and execute the command
        String command = name + " = import.genotypes('" + path + "')";
        RConnectionManager.eval(command);
    }
    
    private void importGistic(String name, String path) {
        // create and execute the command
        String command = name + " = import.GISTIC('" + path + "')";
        RConnectionManager.eval(command);
    }
    
    private void importMaf(String name, String path) {
        // create and execute the command
        String command = name + " = import.MAF('" + path + "', sep = ';')";
        RConnectionManager.eval(command);
    }
    
    public void bindSamples(Dataset dataset, String newName) {
    	// create and execute the command
        String command = newName + " = sbind(c(" + name + ", " + dataset.getName() + "))" + 
        		"\n rm(" + name + ")";
        RConnectionManager.eval(command);
        
        // update the name
        name = newName;
        
        // update the samples and the events
        retrieveSamples();
        retrieveEvents();
    }
    
    public void bindEvents(Dataset dataset, String newName) {
    	// create and execute the command
        String command = newName + " = ebind(c(" + name + ", " + dataset.getName() + "))" + 
        		"\n rm(" + name + ")";
        RConnectionManager.eval(command);
        
        // update the name
        name = newName;
        
        // update the samples and the events
        retrieveSamples();
        retrieveEvents();
    }
    
    public void intersect(Dataset dataset, String newName) {
    	// create and execute the command
        String command = newName + " = intersect.datasets(" + name + ", " + dataset.getName() + ")" + 
        		"\n rm(" + name + ")";
        RConnectionManager.eval(command);
        
        // update the name
        name = newName;
        
        // update the samples and the events
        retrieveSamples();
        retrieveEvents();
    }
    
    // ************ SAMPLES ************ \\
    private void retrieveSamples() {
    	// initialize the structure
    	samples = new HashMap<>();
    	
    	// create and execute the command
        String command = "as.samples(" + name + ")";
        REXP rexp = RConnectionManager.eval(command);
        
        // get the names of the genes
        String[] names = rexp.asStringArray();
        
        // instantiate the genes and add them to the map
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            samples.put(name, new Sample(name));
        }
    }
    
    public void deleteSample(Sample sample) {
    	// create and execute the command
        String command = name + " = delete.samples(" + name + ", c('" + sample.getName() + "'))";
        RConnectionManager.eval(command);
        
        // delete the sample from the map
        samples.remove(sample.getName());
    }
    
    public void samplesSelection(Sample[] samples) {
    	// create and execute the command
        String command = name + " = samples.selection(" + name + ", c(";
        for (int i = 0; i < samples.length; i++) {
        	command += "'" + samples[i].getName() + "'";
        	if (i < samples.length - 1) {
        		command += ", ";
        	}
		}
        command += "))";
        RConnectionManager.eval(command);
        
        // reload the samples
        retrieveSamples();
    }
    
    public Collection<Sample> getSamples() {
    	// order and return the list
    	List<Sample> samplesList = new ArrayList<>(samples.values());
    	Collections.sort(samplesList, new ToStringComparator());
    	return samplesList;
    }
    
    // ************ GENES ************ \\    
    public void renameGene(Gene gene, String newName) {
    	// create and execute the command
        String command = name + " = rename.gene(" + name + ", '" + gene.getName() + "', '" + newName + "')";
        RConnectionManager.eval(command);
        
        // rename the gene
        gene.setName(newName);
    }
    
    public void deleteGene(Gene gene) {
    	// create and execute the command
        String command = name + " = delete.gene(" + name + ", '" + gene.getName() + "')";
        RConnectionManager.eval(command);
        
        // delete the gene from the map
        genes.remove(gene.getName());
        
        // reload the events
        retrieveEvents();
    }
    
    public Collection<Gene> getGenes() {
    	// order and return the list
    	List<Gene> genesList = new ArrayList<>(genes.values());
    	Collections.sort(genesList, new ToStringComparator());
    	return genesList;
    }
    
    // ************ TYPES ************ \\    
    public void renameType(Type type, String newName) {
    	// create and execute the command
        String command = name + " = rename.type(" + name + ", '" + type.getName() + "', '" + newName + "')";
        RConnectionManager.eval(command);
        
        // rename the type
        type.setName(newName);
    }
    
    public void deleteType(Type type) {
    	// create and execute the command
        String command = name + " = delete.type(" + name + ", '" + type.getName() + "')";
        RConnectionManager.eval(command);
        
        // delete the type from the map
        types.remove(type.getName());
        
        // reload the events
        retrieveEvents();
    }
    
    public void joinTypes(Type type1, Type type2, String newName) {
    	// create and execute the command
        String command = name + " = join.types(" + name + ", '" + type1.getName() + "', '" + type2.getName() + "', new.type='" + newName + "')";
        RConnectionManager.eval(command);
        
        // reload the events
        retrieveEvents();
    }
    
    public Collection<Type> getTypes() {
    	// order and return the list
    	List<Type> typesList = new ArrayList<>(types.values());
    	Collections.sort(typesList, new ToStringComparator());
    	return typesList;
    }
    
    // ************ EVENTS ************ \\
    private void retrieveEvents() {
    	// initialize the structures
    	events = new HashSet<>();
    	types = new HashMap<>();
    	genes = new HashMap<>();
    	
    	// create and execute the commands
    	String command = "row.names(as.events(" + name + "))";
        REXP rexp = RConnectionManager.eval(command);
        String commandAttributes = "as.events(" + name + ")";
        REXP rexpAttributes = RConnectionManager.eval(commandAttributes);
        
        // get the events and its attributes
        String[] names = rexp.asStringArray();
        String[] attributes = rexpAttributes.asStringArray();
        
        // if the output of R is null
        if (names == null || attributes == null) {
        	// return
			return;
		}
        
        // instantiate the events and add them to the map
        for (int i = 0; i < names.length; i++) {
        	// get the name, the type and the gene
        	String name = names[i];
        	String typeName = attributes[i];
        	String geneName = attributes[i + names.length];
        	
        	// get the type
        	Type type;
        	if (types.containsKey(typeName)) {
				type = types.get(typeName);
			} else {
				type = new Type(typeName);
				types.put(typeName, type);
			}
        	
        	// get the gene
        	Gene gene;
        	if (genes.containsKey(geneName)) {
        		gene = genes.get(geneName);
			} else {
				gene = new Gene(geneName);
				genes.put(geneName, gene);
			}
        	
        	// add the event
        	events.add(new Event(name, type, gene));
        }
    }
    
    public void deleteEvent(Event event) {
    	// create and execute the command
        String command = name + " = delete.event(" + name + ", '" + event.getGene().getName() + "', '" + event.getType().getName() + "')";
        RConnectionManager.eval(command);
        
        // reload the events
        retrieveEvents();
    }
    
    public void joinEvents(Event event1, Event event2, String geneName, String typeName, String colorName) {
    	// create and execute the command
    	String command = name + " = join.events(" + name + ", '" + event1.getName() + "', '" + event2.getName() +
    			"', new.event='" + geneName + "', new.type='" + typeName + "', event.color='" + colorName + "')";
    	RConnectionManager.eval(command);
    	
    	// reload the events
        retrieveEvents();
    }
    
    public void eventsSelection(String frequence, Event[] selectedEvents, Event[] filteredEvents) {
    	// create and execute the command
        String command = name + " = events.selection(" + name;
        if (frequence.length() > 0) {
			command += ", filter.freq=" + frequence;
		}
        if (selectedEvents.length > 0) {
        	command += ", filter.in.names=c(";
        	for (int i = 0; i < selectedEvents.length; i++) {
        		command += "'" + selectedEvents[i].getGene().getName() + "'";
        		if (i < selectedEvents.length - 1) {
            		command += ", ";
            	}
			}
        	command += ")";
		}
        if (filteredEvents.length > 0) {
        	command += ", filter.out.names=c(";
        	for (int i = 0; i < filteredEvents.length; i++) {
        		command += "'" + filteredEvents[i].getGene().getName() + "'";
        		if (i < filteredEvents.length - 1) {
            		command += ", ";
            	}
			}
        	command += ")";
		}
        command += ")";
        RConnectionManager.eval(command);
        
        // reload the events
        retrieveEvents();
    }
    
    public void trim() {
    	// create and execute the command
        String command = name + " = trim(" + name + ")";
        RConnectionManager.eval(command);
        
        // reload the events
        retrieveEvents();
    }
    
    public Collection<Event> getEvents() {
    	// order and return the list
    	List<Event> eventsList = new ArrayList<>(events);
    	Collections.sort(eventsList, new Comparator<Event>() {
			@Override
			public int compare(Event e1, Event e2) {
				Integer index1 = Integer.parseInt(e1.getName().substring(1));
				Integer index2 = Integer.parseInt(e2.getName().substring(1));
				return index1.compareTo(index2);
			}
		});
    	return eventsList;
    }
    
    // ************ HYPOTHESES AND PATTERNS ************ \\
    public void addHypothesis() {
    	
    }
    
    public void addGroupHypothesis() {
    	
    }
    
    public void addHomologousHypothesis() {
    	
    }
    
    public void deleteHypothesis() {
    	
    }
    
    // ************ OTHERS ************ \\
    public String getName() {
		return name;
	}
    
    @Override
    public String toString() {
        return name;
    }
    
    private class ToStringComparator implements Comparator<Object> {
		@Override
		public int compare(Object o1, Object o2) {
			return o1.toString().compareTo(o2.toString());
		}
    }
    
}
