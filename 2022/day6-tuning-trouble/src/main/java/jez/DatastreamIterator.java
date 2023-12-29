package jez;

import java.util.Iterator;

public class DatastreamIterator implements Iterator<String>
{
	private final String datastream;

	private Integer paquetStart;
	private Integer paquetEnd;

	public DatastreamIterator(String datastream, Integer markerSize)
	{
		this.datastream = datastream;
		this.paquetStart = 0;
		this.paquetEnd = markerSize;
		if (datastream.length() <= paquetEnd)
		{
			throw new IndexOutOfBoundsException("Datastream size should be 4 at least");
		}

	}

	@Override
	public boolean hasNext()
	{
		return paquetEnd < datastream.length();
	}

	@Override
	public String next()
	{
		String paquet = datastream.substring(paquetStart, paquetEnd);
		paquetEnd++;
		paquetStart++;
		return paquet;
	}
}
