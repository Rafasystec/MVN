package br.com.barcadero.web.beans;

import javax.faces.component.UIOutput;

public class BeanReferencia {
	/*
	--------------------------------------------------------------------------------------
		Em algumas ocasições, seu bean pode precisar ter acesso aos componentes da
	página JSF. O acesso direto aos componentes é diferente do acesso aos valores. Este acesso
	dá a possibilidade de inspecionar e até modificar propriedades do componente que está sendo
	renderizado para o usuário, que as vezes pode até não estar disponível como um atributo da
	tag JSF. Por exemplo, um componente de entrada de texto <h:inputText/>, representado
	como objeto Java do tipo UIInput, pode ter a propriedade disabled ou required
	modificadas em tempo de execução pelo código Java, através do acesso direto a este objeto.
		Para esta ligação entre os componentes da página e propriedades de beans,precisamos criar um backing bean. Um bean deste tipo é igual ao managed bean. A única
	diferença é que ele, além de fazer ligações de valor, pode também fazer ligação de
	componentes, porém a forma de configurá-lo no arquivo “faces-config.xml” é a mesma.
	Para um bean ser caracterizado como um backing bean, no código-fonte da página é
	feita uma amarração (melhor chamado de binding) em uma tag de um componente JSF para
	uma propriedade de um backing bean. Para conectar os componentes do formulário com as
	propriedades do bean, usa-se o atributo binding:
	--------------------------------------------------------------------------------------
	 */
	
	private UIOutput component;

	public UIOutput getComponent() {
		return component;
	}

	public void setComponent(UIOutput component) {
		this.component = component;
	}
	
}
