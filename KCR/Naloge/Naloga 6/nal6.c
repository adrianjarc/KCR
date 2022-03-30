#include <gtk/gtk.h>
#include <stdlib.h>
#include <string.h>

GtkBuilder *builder;
GtkWidget *window;
GtkWidget *fc, *status;

void odpri_mb(GtkObject *object, gpointer user_data){
	gtk_widget_show(fc);
}

void cancel_fc(GtkObject *object, gpointer user_data){
	gtk_widget_hide(fc);
}

void odpri_fc(GtkObject *object, gpointer user_data){
	gtk_label_set_text(GTK_LABEL(status), "tuki nej bi ime fajla dal");
	gtk_widget_hide(fc);
}

void author_mb(GtkObject *object, gpointer user_data){
	gtk_label_set_text(GTK_LABEL(status), "Avtor: Jasmin Nadarevic.");
}

int main(int argc, char *argv[]){
	gtk_init(&argc, &argv);
	builder = gtk_builder_new();
	gtk_builder_add_from_file(builder, "6nal.glade", NULL);
	window = GTK_WIDGET(gtk_builder_get_object(builder, "window1"));
	fc = GTK_WIDGET(gtk_builder_get_object(builder, "filechooserdialog1"));
	status = GTK_WIDGET(gtk_builder_get_object(builder, "Status"));
	gtk_builder_connect_signals(builder, NULL);
	gtk_widget_show(window);
	gtk_main();
	return 0;
}
