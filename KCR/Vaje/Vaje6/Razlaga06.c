#include <gtk/gtk.h>
#include <stdlib.h>
#include <string.h>

GtkBuilder *builder;
GtkWidget *window;
GtkWidget *fc, *status, *comboB, *spinB, *entry, *rdb1;

void odpri_cb(GtkObject *object, gpointer user_data){
	gtk_widget_show(fc);
}

void skrij_cb(GtkObject *object, gpointer user_data){
	gtk_widget_hide(fc);
}

void prikazi_cb(GtkObject *object, gpointer user_data){
	gtk_widget_hide(fc);
}

void avtor_cb(GtkObject *object, gpointer user_data){
	gtk_label_set_text(GTK_LABEL(status), "Jaz sem avtor");
}

void pretvori_cb(GtkObject *object, gpointer user_data){
	double conv = 1.28;
	double val = gtk_spin_button_get_value_as_int(GTK_SPIN_BUTTON(spinB));
	if (gtk_combo_box_get_active(GTK_COMBO_BOX(comboB)) == 0) { 
		val *= conv;
	} else {
		val /= conv;
	}

	gchar displ[255];
	sprintf(displ, "%f" , val);
	gtk_entry_set_text(GTK_ENTRY(entry), displ);
}

void izpisi_cb(GtkObject *object, gpointer user_data){
	GtkTreeModel *model = NULL;
	model = gtk_combo_box_get_model(GTK_COMBO_BOX(comboB));
	GtkTreeIter iter;
	GtkTreePath *path = NULL;
	gboolean valid;
	int rcnt = 0;
	valid = gtk_tree_model_get_iter_first(model, &iter);
	while (valid){
		gchar *cdata;
		gtk_tree_model_get(model, &iter, 0, &cdata, -1);
		printf("%d %s\n", rcnt, cdata);
		rcnt++;
		free(cdata);
		gtk_tree_path_free(path);
		path = gtk_tree_model_get_path(model, &iter);
		valid = gtk_tree_model_get_iter_first(model, &iter);
	}
	if (path != NULL){
		if (gtk_tree_model_get_iter(model, &iter, path)){
			gtk_list_store_remove(GTK_LIST_STORE(model), &iter);
		}
	}
}

int main(int argc, char *argv[]){
	gtk_init(&argc, &argv);
	builder = gtk_builder_new();
	gtk_builder_add_from_file(builder, "Razlaga06.glade", NULL);
	window = GTK_WIDGET(gtk_builder_get_object(builder, "window1"));
	fc = GTK_WIDGET(gtk_builder_get_object(builder, "filechooserdialog1"));
	status = GTK_WIDGET(gtk_builder_get_object(builder, "statusBar"));
	comboB = GTK_WIDGET(gtk_builder_get_object(builder, "combobox1"));
	spinB = GTK_WIDGET(gtk_builder_get_object(builder, "spinbutton1"));
	entry = GTK_WIDGET(gtk_builder_get_object(builder, "entry1"));
	rdb1 = GTK_WIDGET(gtk_builder_get_object(builder, "rdb1"));
	gtk_builder_connect_signals(builder, NULL);
	gtk_widget_show(window);
	gtk_main();
	return 0;
}
